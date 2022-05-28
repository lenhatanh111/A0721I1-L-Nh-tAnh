function searchAuthor() {
    let name = $("#searchValue").val();
    $.ajax({
        url: "http://localhost:8080/api/blog/searchAuthor",
        data: {
            name: name
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            console.log(response)
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `
                    <tr>
                        <td>${response[i].id}</td>
                        <td>${response[i].title}</td>
                        <td>${response[i].content}</td>
                        <td>${response[i].author}</td>
                        <td>${response[i].category.name}</td>
                        <td>${response[i].releaseDate}</td>
                    </tr>
                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });
}