<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT ari.id FROM ari UNION SELECT compresseurs.id FROM compresseurs;");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
    }
    echo json_encode(array(
        'liste_elem'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
