<?php
require_once '../config.php';

if (isset($_POST['id']) && isset($_POST['etat_gonflage']) && isset($_POST['lieu_stock'])) {

    $insert1 = $bdd->prepare("INSERT INTO ari(id, etat_gonflage,lieu_stock ) VALUES (?,?,?)");
    $insert1->execute(array($_POST['id'], $_POST['etat_gonflage'], $_POST['lieu_stock']));
    echo "Ari " . $_POST['id'] . " ajouté ";

} else {
    echo 'Les variables du formulaire ne sont pas déclarées';
}