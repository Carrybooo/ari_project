<?php
require_once '../config.php';
if (isset($_POST['id']) && isset($_POST['etat_gonflage'])) {
    $insert = $bdd->prepare("UPDATE ari SET etat_gonflage= ? WHERE id= ?");
    $insert->execute(array( $_POST['etat_gonflage'],$_POST['id']) );
echo "L'etat de gonflage de ".$_POST['id']." a été modifié ";
}
else if (isset($_GET['id']) && isset($_GET['etat_gonflage'])) {
    $insert = $bdd->prepare("UPDATE ari SET etat_gonflage= ? WHERE id= ?");
    $insert->execute(array( $_GET['etat_gonflage'],$_GET['id']) );
echo json_encode("L'etat de gonflage de ".$_GET['id']." a été modifié ");
}
else {
	echo json_encode('Les variables du formulaire ne sont pas déclarées');
}