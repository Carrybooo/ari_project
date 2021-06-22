
<?php
// $_SESSION['userId'] = 'oui';
try{
    $bdd = new PDO('mysql:host=localhost;dbname=poseidon', 'root','');

}
catch(Exception $e){
echo $e->getMessage();
}
// if (isset($_SESSION['userId'])) {
    try {
        $dataArray = array();
        $reponse = $bdd->query("SELECT * FROM ari");
        $donnees = $reponse->fetchALL(PDO::FETCH_ASSOC);
        header('Content-Type: application/json');

        foreach ($donnees as $key => $value) {
            $dataArray[$key]['id'] = $donnees[$key]['id'];
            $dataArray[$key]['etat_gonflage'] = $donnees[$key]['etat_gonflage'];
            $dataArray[$key]['lieu_stock'] = $donnees[$key]['lieu_stock'];
            $dataArray[$key]['reparation'] = $donnees[$key]['reparation'];
            $dataArray[$key]['controle'] = $donnees[$key]['controle'];
            $dataArray[$key]['utilisation'] = $donnees[$key]['utilisation'];
            $dataArray[$key]['vehicule'] = $donnees[$key]['vehicule'];
        }
        http_response_code(200);
        echo json_encode(array(
            'ari_list' => $dataArray));
    } catch (Exception $e) {
        echo $e->getMessage();
    }
//header("location:../../index.php?page=listAri");
