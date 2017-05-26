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


