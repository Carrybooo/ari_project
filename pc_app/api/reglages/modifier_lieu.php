<?php
require_once '../config.php';
if (isset($_POST['id']) && isset($_POST['lieu_stock'])) {
    $insert = $bdd->prepare("UPDATE ari SET lieu_stock= ?");
    $insert->execute(array( $_POST['lieu_stock']));

echo "Le lieu de stock de ".$_POST['id']." a été modifié ";
}
else {
	echo 'Les variables du formulaire ne sont pas déclarées';
}