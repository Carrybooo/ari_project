<?php
//demarrer la session
session_start();

//la detruire
session_unset();

session_destroy() ;

//rediriger vers le formulaire d'accueil
header ('location: index1.html');
?>




