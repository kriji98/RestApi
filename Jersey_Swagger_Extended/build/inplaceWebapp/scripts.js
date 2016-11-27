var currentPage = 1;
var sentRequest = false;

function getData(argument) {
	$.ajax({
		url: "http://localhost:8081/rst/api/books",
		type: "GET",
		dataType: "json",
		data: argument,
		success: function(data) {
			
			if(argument.newPage == undefined){
				$("#booksTable tr").remove();
			} else {
				currentPage = argument.newPage + 1;
			}
			
			console.log(data);
			$.each(data, function(index) {
				var tr = $('<tr>');
				tr.append("<td>" + data[index].id + "</td>");
				tr.append("<td>" + data[index].name + "</td>");
				tr.append("<td>" + data[index].authorName + "</td>");
				tr.append("<td>" + data[index].genre + "</td>");
				tr.append("<td>" + data[index].yearIssue + "</td>");
				$("#booksTable").append(tr);
			});
			sentRequest = false;
		}
	});
}

$(document).ready(function() {
	var pageIndex = {
			bookNumber: 20,
			newPage: currentPage
	};
	getData(pageIndex);
	
	$('#input-data-books').submit(function(event) {
		event.preventDefault();
		var submissionData = {
			name: $('#name-book').val(),
			authorName : $('#author-name-book').val(),
			genre: $('#genre').val(),
			yearIssue: $('#year-issue').val()
		}
		
		console.log(submissionData);
		$.ajax({
			type: 'POST',
			data: JSON.stringify(submissionData),
			url: 'api/books',
			contentType : 'application/json'
		});
		
		document.getElementById("name-book").value = '';
		document.getElementById("author-name-book").value = '';
		document.getElementById("genre").value = '';
		document.getElementById("year-issue").value = '';
	});
	
	$('#filter-books').submit(function(event) {
		event.preventDefault();
		
		var filterData = {
			name: $('#filter-name-book').val(),
			authorName : $('#filter-author-book').val(),
			genre: $('#filter-genre').val(),
			yearIssue: $('#filter-year-issue').val(),
			newPage: 1,
			bookNumber: 20
		};
		console.log(filterData);
		
		$("#booksTable tr").remove();
		if(!sentRequest){
			currentPage = 1;
			getData(filterData);
			sentRequest = true;
		}
		
	});
	console.log("moje bi tuka");
	$(window).scroll(function() {
		console.log("veche sym tyka");
		if ($(window).scrollTop() + $(window).height() >= $('body').height()) {
			console.log("eto tuka sym");
			console.log($(window).scrollTop());
			console.log($(window).height());
			console.log($('body').height());
			var pageIndex = {
					name: $('#filter-name-book').val(),
					authorName : $('#filter-author-book').val(),
					genre: $('#filter-genre').val(),
					yearIssue: $('#filter-year-issue').val(),
					bookNumber: 20,
					newPage: currentPage
			};
			if (!sentRequest) {
				getData(pageIndex);
				sentRequest = true;
			}
		}
	})
});