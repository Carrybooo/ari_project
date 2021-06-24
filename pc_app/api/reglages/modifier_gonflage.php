<?php
require_once '../config.php';
if (isset($_POST['id']) && isset($_POST['etat_gonflage'])) {
    $insert = $bdd->prepare("UPDATE ari SET etat_gonflage= ?");
    $insert->execute(array( $_POST['etat_gonflage']));
echo "L'etat de gonflage de ".$_POST['id']." a été modifié ";
}
else {
	echo 'Les variables du formulaire ne sont pas déclarées';
}