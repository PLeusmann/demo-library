function runVue() {
	var library = new Vue({
		el : '#library',
		data : {
			message : "Hallo Leser",
			books : [],
			users : [],
			isNewBookFormVisible: false,
			newBook : new Object(),
			restError : undefined
		},
		methods: {
			loadBooks : function() {
		        var vm = this
		        axios.get('https://1m4abxboc8.execute-api.eu-central-1.amazonaws.com/rest/book')
		          .then(function (response) {
		            vm.books = response.data
		          })
		          .catch(function (error) {
		            vm.restError = error
		          })
			},
			loadUsers : function() {
		        var vm = this
		        axios.get('https://1m4abxboc8.execute-api.eu-central-1.amazonaws.com/rest/user')
		          .then(function (response) {
		            vm.users = response.data
		          })
		          .catch(function (error) {
		            vm.restError = error
		          })
			},
			showNewBookForm : function() {
				this.isNewBookFormVisible = true;
				this.newBook = new Object();
			},
			saveBook : function() {
				var vm = this
		        axios.post('https://1m4abxboc8.execute-api.eu-central-1.amazonaws.com/rest/book', vm.newBook)
		          .then(function (response) {
		            vm.loadBooks();
		            this.isNewBookFormVisible = false;
		            
		          })
		          .catch(function (error) {
		        	  this.showNewBookForm = false;
		        	  vm.restError = error
		          })
			}
		}
	});
	
	library.loadBooks();
	library.loadUsers();
}