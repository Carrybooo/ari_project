<?php
//si le login vaut toto (a remplacer plus tard par une recherche dans la BDD)
$email_valide = "toto";
$password_valide = "titi";

 if (isset($_POST['email']) && isset($_POST['password'])) {
 	if ($email_valide == $_POST['email'] && $password_valide == $_POST['password']) {
//demarrer la session
   		session_start ();
   		
//créer une variable de session qui s'appelle connecte et qui vaut "oui"
    	$_SESSION['connecte']="oui";

//creer une variable de session qui s'appelle login et qui vaut le login
   		$_SESSION['email'] = $_POST['email'];
    	$_SESSION['password'] = $_POST['password'];
    	
//puis rediriger vers la page privee 1
   		header ('location: index.php');
    	}
//sinon rediriger vers la page d'accueil
   	else {
   		echo '<body onLoad="alert(\'Votre Email ou votre Mot de passe incorrect\')">';
   		echo '<meta http-equiv="refresh" content="0;URL=index1.html">';
   	}
 }
else {
  	echo 'Erreur sur les variables';
 }
?>




