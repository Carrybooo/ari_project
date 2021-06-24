<?php
require_once '../config.php';

if (isset($_POST['id'])) {

    $insert1 = $bdd->prepare("DELETE FROM ari WHERE id= ? ");
    $insert1->execute(array($_POST['id']));
    echo "Ari " . $_POST['id'] . " retiré ";

} else {
    echo 'Les variables du formulaire ne sont pas déclarées';
}