/**
 * Created by BPCT on 5/26/2017.
 */

$("#new-job-button").click( function() {
    $('#new-note').toggleClass('clicked');
});

$("#close").click( function () {
    $('#new-note').toggleClass('clicked');

});

$("#new-job-button").add(function () {
    if (top.location.pathname != '/'){
        $("#new-job-button").hide()
    }
} );

$( document ).ready(function() {
    $('#radio-new-job').hide()
});


// new note option to select job or add new job
$("#inlineRadio1").on('click', function() {

        $('#radio-new-job').show()
        $('#radio-add-to-job').hide()
});

$("#inlineRadio2").on('click', function() {

    $('#radio-new-job').hide()
    $('#radio-add-to-job').show()

});

