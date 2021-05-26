        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();

        // //handling of formData
        // document.addEventListener('DOMContentLoaded', () => {
        //     document
        //         .getElementById('registerform')
        //         .addEventListener('submit', handleForm);
        // });

        // function handleForm(event) {
        //     event.preventDefault();
        //     //console.dir
        //     let registerform = event.target;
        //     let fd = new FormData(registerform);

        //     //add more things that were not in form
        //     //-- fd.append('this', 'the this);

        //     //look at all the contents
        //     for (let key of fd.keys()) {
        //         console.log(key, fd.get(key));
        //     }


        //     let json = convertFD2JSON(fd);
        //     //send the request with the formData to spring server
        //     let url = 'http://localhost:3030/registration';
        //     let head = new Headers();
        //     head.append('Content-Type', 'application/json');

        //     let req = new Request(url, {
        //         headers: head,
        //         body: json,
        //         method: 'POST',
        //     });

        //     //console.log(req) to see if the suff is posted 
        //     //fetch the request
        //     fetch(req)
        //         .then((res) => res.json())
        //         .then((data) => {
        //             console.log('Response from server');
        //             console.log(data);
        //         })
        //         .catch(console.warn);
        // }

        // //converting formData string to JSON
        // function convertFD2JSON(formData) {
        //     let obj = {};
        //     for (let key of formData.keys()) {
        //         obj[key] = formData.get(key);
        //     }
        //     return JSON.stringify(obj);
        // }