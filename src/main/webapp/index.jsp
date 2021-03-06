<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="main.css">
    <title>Register</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="logo.png" alt="" width="30" height="24">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
                </ul>
                <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <hr>
	

    <div class="container h-50">
        <div class="row h-50 justify-content-center align-items-center">
            <div class="col-11 col-md-10 col-lg-10">
            <h4 style="color:#5f73ad"><i>Veuillez entrer vos informations pour cr??er un compte</i></h4>
                <form action = "index" class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                        <label for="validationServer01" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="validationServer01" name="nom" required>
                        <div class="invalid-feedback">
                            Entrer votre nom.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="validationServer02" class="form-label">Prenom</label>
                        <input type="text" class="form-control" id="validationServer02" name="prenom" required>
                         <div class="invalid-feedback">
                            Entrer votre prenom.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="validationServer02" class="form-label">Pseudo</label>
                        <input type="text" class="form-control" id="validationServer02" name="pseudo" required>
                         <div class="invalid-feedback">
                            Entrer votre pseudo.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="validationServer02" class="form-label">Login</label>
                        <input type="text" class="form-control" id="validationServer02"  name="login" required>
                         <div class="invalid-feedback">
                            Entrer votre Login.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="validationServer02" class="form-label">Mot de passe</label>
                        <input type="text" class="form-control" id="validationServer02" name="mdp" required>
                         <div class="invalid-feedback">
                            Entrer votre Mot de passe.
                        </div>
                    </div>
                    
                    <div class="col-12">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                            <label class="form-check-label" for="invalidCheck3">
                                Agree to terms and conditions
                            </label>
                            <div id="invalidCheck3Feedback" class="invalid-feedback">
                                You must agree before submitting.
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <input type="submit" class="btn btn-primary" value="s'inscrire">
                        <!-- <button class="btn btn-primary" type="submit">Submit form</button> -->
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    <script>
 
        var form = document.querySelector('.needs-validation');

        form.addEventListener('submit', function(event) {
            if (form.checkValidity()==false) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        })
        
    </script>

</body>
</html>