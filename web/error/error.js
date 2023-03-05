///* 
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
// */
//
//tinymce.init({
//  selector: '#basic-conf',
//  
//  plugins: [
//    'advlist', 'autolink', 'link', 'image', 'lists', 'charmap', 'preview', 'anchor', 'pagebreak',
//    'searchreplace', 'wordcount', 'visualblocks', 'code', 'fullscreen', 'insertdatetime', 'media',
//    'table', 'emoticons', 'template', 'help'
//  ],
//  toolbar: 'undo redo | styles | bold italic | alignleft aligncenter alignright alignjustify | ' +
//    'bullist numlist outdent indent | link image | print preview media fullscreen | ' +
//    'forecolor backcolor emoticons | help',
//  menu: {
//    favs: { title: 'My Favorites', items: 'code visualaid | searchreplace | emoticons' }
//  },
//  menubar: 'favs file edit view insert format tools table help',
//  content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }',
//  file_picker_types: 'image',
//  file_picker_callback: function(cb, value, meta) {
//    var input = document.createElement('input');
//    input.setAttribute('type', 'file');
//    input.setAttribute('accept', 'image/*');
//
//    input.onchange = function() {
//      var file = this.files[0];
//      var reader = new FileReader();
//      
//      reader.onload = function () {
//        var id = 'blobid' + (new Date()).getTime();
//        var blobCache =  tinymce.activeEditor.editorUpload.blobCache;
//        var base64 = reader.result.split(',')[1];
//        var blobInfo = blobCache.create(id, file, base64);
//        blobCache.add(blobInfo);
//
//        // call the callback and populate the Title field with the file name
//        cb(blobInfo.blobUri(), { title: file.name });
//      };
//      reader.readAsDataURL(file);
//    };
//    
//    input.click();
//  }
//});