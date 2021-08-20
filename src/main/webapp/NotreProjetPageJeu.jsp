<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <style>

      .box{
        border:solid black;
        background-color:white;
        display:flex;
        flex-direction:column;
        justify-content:space-between;
        margin:2px
      }


      .form-select{
        display:inline-block;
      }

      }
    </style>
  </head>
  <body>

    <header>
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
    </header>

    <main>

      <div class="container">
        <div class="row row-cols-2" style="--bs-gutter-y: 20px; ">

          <div class="col" style= " padding-top: calc(var(--bs-gutter-x) * .5); padding-bottom: calc(var(--bs-gutter-x) * .5);">
              Joueur1
              <table class="table table-striped">
                <tr>
                  <th><img height="40px" width="40px" src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg" alt=" bois"> :0 </th>
                  <th> <img height="40px" width="40px" src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png" alt="pierre">:0</th>
                  <th> <img height="40px" width="40px" src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg" alt="minerais">:0</th>
                  <th> <img height="40px" width="40px" src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg" alt="or">:0</th>
                  <th> <img height="40px" width="40px" src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg" alt="fer">:0</th>
                  <th> <img height="40px" width="40px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg" alt="cuivre">:0</th>
                </tr>
              </table>
              <table class="table table-striped">
                <tr>
                  <th> Batiment </th>
                  <th> Attaque</th>
                  <th> Défense</th>
                  <th> Niveau</th>
                </tr>
                <tr>
                  <td> Bastide </td>
                  <td> 0 </td>
                  <td> 50</td>
                  <td> 1 </td>
                </tr>
                <tr>
                  <td> Catapulte </td>
                  <td> 20 </td>
                  <td> 50</td>
                  <td> 1 </td>
                </tr>
                <tr>
                  <td> Four </td>
                  <td> 0 </td>
                  <td> 50</td>
                  <td> 1 </td>
                </tr>
              </table>
              <table class="table table-striped">
                <tr>
                  <th>Total</th>
                  <th>Attaque: 20</th>
                  <th>Défense: 150</th>
              </table>
              <div>
                <select class="form-select" aria-label="Default select example" style="width:48%;">
                  <option selected> Transformer</option>
                  <option value="1">Charbon</option>
                  <option value="2">Or</option>
                  <option value="3">Fer</option>
                  <option value="4">Cuivre</option>
                </select>
                <select class="form-select" aria-label="Default select example" style="width:48%;">
                  <option selected> construire</option>
                  <option value="1">Catapulte</option>
                  <option value="2">Forteresse</option>
                  <option value="3">Four</option>
                  <option value="4">Fonderie</option>
                  <option value="2">Muraille</option>
                  <option value="3">Merveille</option>
                  <option value="4">Scierie</option>
                  <option value="2">Carrière</option>
                  <option value="3">Mine</option>
                </select>
              </div>
            <div>
              <select class="form-select" aria-label="Default select example" style="width:32%;">
                <option selected> Attaquer</option>
                <option value="1">J1</option>
                <option value="2">J2</option>
                <option value="3">J3</option>
                <option value="4">J4</option>
              </select>
              <select class="form-select" aria-label="Default select example" style="width:32%;">
                <option selected> batiment d'attaque</option>
                <option value="1">Tous</option>
                <option value="2">Catapulte</option>
                <option value="3">Etc.</option>

              </select>
              <select class="form-select" aria-label="Default select example" style="width:32%;">
                <option selected> Batiment adverse</option>
                <option value="1">Tous</option>
                <option value="2">Fonderie</option>
                <option value="3">Je sais pas</option>
                <option value="4">Va savoir</option>
              </select>
            </div>
            <div>
              <button type="submit" class="btn btn-success">Valider action</button>
              <button type="button" class="btn btn-danger">Fin du tour</button>
            </div>
          </div>

          <div class="col" style="padding-top: calc(var(--bs-gutter-x) * .5); padding-bottom: calc(var(--bs-gutter-x) * .5);">
            Joueur2
            <table class="table table-striped">
              <tr>
                <th><img height="40px" width="40px" src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg" alt=" bois"> :0 </th>
                <th> <img height="40px" width="40px" src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png" alt="pierre">:0</th>
                <th> <img height="40px" width="40px" src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg" alt="minerais">:0</th>
                <th> <img height="40px" width="40px" src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg" alt="or">:0</th>
                <th> <img height="40px" width="40px" src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg" alt="fer">:0</th>
                <th> <img height="40px" width="40px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg" alt="cuivre">:0</th>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th> Batiment </th>
                <th> Attaque</th>
                <th> Défense</th>
                <th> Niveau</th>
              </tr>
              <tr>
                <td> Bastide </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Catapulte </td>
                <td> 20 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Four </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th>Total</th>
                <th>Attaque: 20</th>
                <th>Défense: 150</th>
            </table>
            <div>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> Transformer</option>
                <option value="1">Charbon</option>
                <option value="2">Or</option>
                <option value="3">Fer</option>
                <option value="4">Cuivre</option>
              </select>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> construire</option>
                <option value="1">Catapulte</option>
                <option value="2">Forteresse</option>
                <option value="3">Four</option>
                <option value="4">Fonderie</option>
                <option value="2">Muraille</option>
                <option value="3">Merveille</option>
                <option value="4">Scierie</option>
                <option value="2">Carrière</option>
                <option value="3">Mine</option>
              </select>
            </div>
            <div>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Attaquer</option>
              <option value="1">J1</option>
              <option value="2">J2</option>
              <option value="3">J3</option>
              <option value="4">J4</option>
            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> batiment d'attaque</option>
              <option value="1">Tous</option>
              <option value="2">Catapulte</option>
              <option value="3">Etc.</option>

            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Batiment adverse</option>
              <option value="1">Tous</option>
              <option value="2">Fonderie</option>
              <option value="3">Je sais pas</option>
              <option value="4">Va savoir</option>
            </select>
            </div>
            <div>
              <button type="submit" class="btn btn-success">Valider action</button>
              <button type="button" class="btn btn-danger">Fin du tour</button>
            </div>
            </div>




          <div class="col" style="padding-top: calc(var(--bs-gutter-x) * .5); padding-bottom: calc(var(--bs-gutter-x) * .5);">
            Joueur3
            <table class="table table-striped">
              <tr>
                <th><img height="40px" width="40px" src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg" alt=" bois"> :0 </th>
                <th> <img height="40px" width="40px" src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png" alt="pierre">:0</th>
                <th> <img height="40px" width="40px" src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg" alt="minerais">:0</th>
                <th> <img height="40px" width="40px" src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg" alt="or">:0</th>
                <th> <img height="40px" width="40px" src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg" alt="fer">:0</th>
                <th> <img height="40px" width="40px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg" alt="cuivre">:0</th>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th> Batiment </th>
                <th> Attaque</th>
                <th> Défense</th>
                <th> Niveau</th>
              </tr>
              <tr>
                <td> Bastide </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Catapulte </td>
                <td> 20 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Four </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th>Total</th>
                <th>Attaque: 20</th>
                <th>Défense: 150</th>
            </table>
            <div>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> Transformer</option>
                <option value="1">Charbon</option>
                <option value="2">Or</option>
                <option value="3">Fer</option>
                <option value="4">Cuivre</option>
              </select>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> construire</option>
                <option value="1">Catapulte</option>
                <option value="2">Forteresse</option>
                <option value="3">Four</option>
                <option value="4">Fonderie</option>
                <option value="2">Muraille</option>
                <option value="3">Merveille</option>
                <option value="4">Scierie</option>
                <option value="2">Carrière</option>
                <option value="3">Mine</option>
              </select>
            </div>
            <div>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Attaquer</option>
              <option value="1">J1</option>
              <option value="2">J2</option>
              <option value="3">J3</option>
              <option value="4">J4</option>
            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> batiment d'attaque</option>
              <option value="1">Tous</option>
              <option value="2">Catapulte</option>
              <option value="3">Etc.</option>

            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Batiment adverse</option>
              <option value="1">Tous</option>
              <option value="2">Fonderie</option>
              <option value="3">Je sais pas</option>
              <option value="4">Va savoir</option>
            </select>
            </div>
            <div>
              <button type="submit" class="btn btn-success">Valider action</button>
              <button type="button" class="btn btn-danger">Fin du tour</button>
            </div>
            </div>




          <div class="col" style="padding-top: calc(var(--bs-gutter-x) * .5); padding-bottom: calc(var(--bs-gutter-x) * .5);">

            Joueur4
            <table class="table table-striped">
              <tr>
                <th><img height="40px" width="40px" src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg" alt=" bois"> :0 </th>
                <th> <img height="40px" width="40px" src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png" alt="pierre">:0</th>
                <th> <img height="40px" width="40px" src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg" alt="minerais">:0</th>
                <th> <img height="40px" width="40px" src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg" alt="or">:0</th>
                <th> <img height="40px" width="40px" src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg" alt="fer">:0</th>
                <th> <img height="40px" width="40px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg" alt="cuivre">:0</th>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th> Batiment </th>
                <th> Attaque</th>
                <th> Défense</th>
                <th> Niveau</th>
              </tr>
              <tr>
                <td> Bastide </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Catapulte </td>
                <td> 20 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
              <tr>
                <td> Four </td>
                <td> 0 </td>
                <td> 50</td>
                <td> 1 </td>
              </tr>
            </table>
            <table class="table table-striped">
              <tr>
                <th>Total</th>
                <th>Attaque: 20</th>
                <th>Défense: 150</th>
            </table>
            <div>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> Transformer</option>
                <option value="1">Charbon</option>
                <option value="2">Or</option>
                <option value="3">Fer</option>
                <option value="4">Cuivre</option>
              </select>
              <select class="form-select" aria-label="Default select example" style="width:48%;">
                <option selected> construire</option>
                <option value="1">Catapulte</option>
                <option value="2">Forteresse</option>
                <option value="3">Four</option>
                <option value="4">Fonderie</option>
                <option value="2">Muraille</option>
                <option value="3">Merveille</option>
                <option value="4">Scierie</option>
                <option value="2">Carrière</option>
                <option value="3">Mine</option>
              </select>
            </div>
            <div>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Attaquer</option>
              <option value="1">J1</option>
              <option value="2">J2</option>
              <option value="3">J3</option>
              <option value="4">J4</option>
            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> batiment d'attaque</option>
              <option value="1">Tous</option>
              <option value="2">Catapulte</option>
              <option value="3">Etc.</option>

            </select>
            <select class="form-select" aria-label="Default select example" style="width:32%;">
              <option selected> Batiment adverse</option>
              <option value="1">Tous</option>
              <option value="2">Fonderie</option>
              <option value="3">Je sais pas</option>
              <option value="4">Va savoir</option>
            </select>
            </div>
            <div>
              <button type="submit" class="btn btn-success">Valider action</button>
              <button type="button" class="btn btn-danger">Fin du tour</button>
            </div>
            </div>

          </div>
        </div>
      </div>

    </main>

    <footer>

    </footer>

  </body>
</html>
