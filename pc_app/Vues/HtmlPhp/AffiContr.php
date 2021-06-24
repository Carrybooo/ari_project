<?php
//require '../../api/config.php';
//require '../../api/ari/liste_ari.php';
$content = file_get_contents('http://ari.juliendrieu.fr/api/historiquecontrole/liste_historique_controle.php');
$json = json_decode($content, true);
?>
<html>
<head>
	<title>Liste des Controles</title>
	<meta charset="utf-8">
</head>
<style>
table {
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
}
table td {
  border: 2px solid black;
}
table th {
  border: 2px solid black;
}
table tr:first-child td {
  border-top: 0;
}
table tr td:first-child {
  border-left: 0;
}
table tr:last-child td {
  border-bottom: 0;
}
table tr td:last-child {
  border-right: 0;
}
</style>
<body>
	<h3>La liste de tous les Controles</h3>
<table>
<thead>
  <tr>
    <th>ID</th>
    <th>Date</th>
    <th>Executeur</th>
  </tr>
</thead>
<tbody >
	<?php
foreach ($json['historique_controle'] as $key => $value) {

    ?>
  <tr >
    <td ><?php echo $json['historique_controle'][$key]['id']; ?></td>
    <td><?php echo $json['historique_controle'][$key]['date']; ?></td>
    <td><?php echo $json['historique_controle'][$key]['executeur']; ?></td>
  </tr>
  <?php
}
;
?>
</tbody>
</table>
<a href="http://ari.juliendrieu.fr"><button>Retour</button></a>
</body>
</html>