/*
var totalFileLength, totalUploaded, fileCount, filesUploaded;

function debug(s) {
    var debug = document.getElementById('debug');
    if (debug) {
        debug.innerHTML = debug.innerHTML + '<br/>' + s;
    }
}

function onUploadComplete(e) {
    totalUploaded += document.getElementById('files').
        files[filesUploaded].size;
    filesUploaded++;
    debug('complete ' + filesUploaded + " of " + fileCount);
    debug('totalUploaded: ' + totalUploaded);
    if (filesUploaded < fileCount) {
        uploadNext();
    } else {
        var bar = document.getElementById('bar');
        bar.style.width = '100%';
        bar.innerHTML = '100% complete';
        alert('Finished uploading file(s)');
    }
}

function onFileSelect(e) {
    var files = e.target.files; // FileList object
    var output = [];
    fileCount = files.length;
    totalFileLength = 0;
    for (var i=0; i<fileCount; i++) {
        var file = files[i];
        output.push(file.name, ' (',
            file.size, ' bytes, ',
            file.lastModifiedDate.toLocaleDateString(), ')'
        );
        output.push('<br/>');
        debug('add ' + file.size);
        totalFileLength += file.size;
    }
    document.getElementById('selectedFiles').innerHTML =
        output.join('');
    debug('totalFileLength:' + totalFileLength);
}

function onUploadProgress(e) {
    if (e.lengthComputable) {
        var percentComplete = parseInt(
            (e.loaded + totalUploaded) * 100
            / totalFileLength);
        var bar = document.getElementById('bar');
        bar.style.width = percentComplete + '%';
        bar.innerHTML = percentComplete + ' % complete';
    } else {
        debug('unable to compute');
    }
}

function onUploadFailed(e) {
    alert("Error uploading file");
}

function uploadNext() {
    var xhr = new XMLHttpRequest();
    var fd = new FormData();
    var file = document.getElementById('files').
        files[filesUploaded];
    fd.append("multipartFile", file);
    xhr.upload.addEventListener(
        "progress", onUploadProgress, false);
    xhr.addEventListener("load", onUploadComplete, false);
    xhr.addEventListener("error", onUploadFailed, false);
    xhr.open("POST", "file_upload");
    debug('uploading ' + file.name);
    xhr.send(fd);
}

function startUpload() {
    totalUploaded = filesUploaded = 0;
    uploadNext();
}

window.onload = function() {
    document.getElementById('files').addEventListener(
        'change', onFileSelect, false);
    document.getElementById('uploadButton').
    addEventListener('click', startUpload, false);
}*/

/*
 * jQuery File Upload Video Preview Plugin 1.0.3
 * https://github.com/blueimp/jQuery-File-Upload
 *
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */

/* jshint nomen:false */
/* global define, window, document */

var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/personinfo/"+userid,
        dataType:"json",
        global:"false",
        success:function(data) {
            alert("!!!");
        },
        /* success:function(data){
           alert(JSON.stringify(data));
         },*/
        error:function(){
            alert("Please Log In First");
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});

$(function () {
    'use strict';
    var reg=$('#fileupload');
    // Initialize the jQuery File Upload widget:
    reg.fileupload({
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},
        url: 'user/testpersonimg'
    });

    // Enable iframe cross-domain access via redirect option:
    reg.fileupload(
        'option',
        'redirect',
        window.location.href.replace(
            /\/[^\/]*$/,
            '/cors/result.html?%s'
        )
    );
    reg.addClass('fileupload-processing');
    $.ajax({
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},
        url: reg.fileupload('option', 'url'),
        dataType: 'json',
        context: reg[0]
    }).always(function () {
        $(this).removeClass('fileupload-processing');
    }).done(function (result) {
        $(this).fileupload('option', 'done')
            .call(this, $.Event('done'), {result: result});
    });

});
