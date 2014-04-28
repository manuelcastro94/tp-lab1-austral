/**
 * Created by Federico on 28/04/2014.
 */
function sendAjax() {

    // get inputs
    var question = new Object();
    question.question = $('#question').val();
    question.user = $('#user').val();
    question.answers = $('#answers').val().split(";");

    $.ajax({
        url: "LoadQuestionServlet",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(question),
        contentType: 'application/json',
        mimeType: 'application/json',

        success: function (data) {
            $("tr:has(td)").remove();

            $.each(data, function (index, question) {

                var td_categories = $("<td/>");
                $.each(question.answers, function (i, answer) {
                    var span = $("<span class='label label-info' style='margin:4px;padding:4px' />");
                    span.text(answer);
                    td_categories.append(span);
                });

//                $("#added-articles").append($('<tr/>')
//                        .append($('<td/>').html("<a href='"+question.url+"'>"+question.question+"</a>"))
//                        .append(td_categories)
//                        .append(td_tags)
//                );

            });
        },
        error: function (data, status, er) {
            alert("error: " + data + " status: " + status + " er:" + er);
        }
    });
}