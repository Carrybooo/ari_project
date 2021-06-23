<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM historiquegonflage");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['date'] = $donnees[$key]['date'];
        $dataArray[$key]['lieu'] = $donnees[$key]['lieu'];
        $dataArray[$key]['compresseur'] = $donnees[$key]['compresseur'];
    }
    echo json_encode(array(
        'historique_gonflage'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
