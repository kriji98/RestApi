function getData() {
	$.ajax({
		url : "http://localhost:8081/rst/api/books",
		type : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data);
			$.each(data, function(index) {
				var tr = $('<tr>');
				tr.append("<td> " + data[index].id + "</td>");
				tr.append("<td> " + data[index].name + "</td>");
				tr.append("<td> " + data[index].authorName + "</td>");
				tr.append("<td> " + data[index].genre + "</td>");
				tr.append("<td> " + data[index].yearIssue + "</td>");
				$("#booksTable").append(tr);
			});
		}
	});
}

$(document).ready(function() {
	getData();
	$('#input-data-books').submit(function(event) {
		event.preventDefault();
		var submissionData = {
			name : $('#name-book').val(),
			authorName : $('#author-name-book').val(),
			genre : $('#genre').val(),
			yearIssue : $('#year-issue').val()
		}
		console.log(submissionData);
		$.ajax({
			type : 'POST',
			data : JSON.stringify(submissionData),
			url : 'api/books',
			contentType : 'application/json'
		});
		document.getElementById("name-book").value = '';
		document.getElementById("author-name-book").value = '';
		document.getElementById("genre").value = '';
		document.getElementById("year-issue").value = '';
	});
});