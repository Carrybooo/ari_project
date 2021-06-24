<?php
//require '../../api/config.php';
//require '../../api/ari/liste_ari.php';
$content = file_get_contents('http://ari.juliendrieu.fr/api/compresseurs/liste_comp.php');
$json = json_decode($content, true);
?>
<html>
<head>
	<title>Liste des Compresseurs</title>
  <link rel="stylesheet" href="../../style.css" media="screen" type="text/css" />
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
  <form>
	<h3>La liste de tous les Compresseurs</h3>
<table>
<thead>
  <tr>
    <th>ID</th>
    <th>Fonctionnel</th>
    <th>Lieu de Stock</th>
  </tr>
</thead>
<tbody >
	<?php
foreach ($json['comp_list'] as $key => $value) {

    ?>
  <tr >
    <td ><?php echo $json['comp_list'][$key]['id']; ?></td>
    <td><?php echo $json['comp_list'][$key]['fonctionnel']; ?></td>
    <td><?php echo $json['comp_list'][$key]['lieu_stock']; ?></td>
  </tr>
  <?php
}
;
?>
</tbody>
</table>
</form>
<a href="http://ari.juliendrieu.fr"><button>Retour</button></a>
</body>
</html>