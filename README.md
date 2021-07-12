# Documentação da API
<table>
	<th>URL Base</th>
	<tr>
		<td>http://localhost:8080/api</td>
	</tr>
</table>

## 1. Usuários
### a. Criar usuário
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/users</td>
		</tr>
</table>

#### Request body
```javascript
{
	"name": "Andre",
	"seller": true
}
```
#### Response
Success status: `201 Created`
```javascript
{
  "userId": 1,
  "userName": "Andre"
}
```
<hr/>

### b. Seguir usuário vendedor [US 0001]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/users/{userId}/follow/{userIdToFollow}</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`

<hr/>

### c. Deixar de seguir usuário vendedor [US 0007]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/users/{userId}/unfollow/{userIdToUnfollow}</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
<hr/>

### d. Obter o resultado do número de usuários que seguem um determinado vendedor [US 0002]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/users/{userId}/followers/count</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
  "userId": 1,
  "userName": "Andre",
  "followers_count": 1
}
```
<hr/>

### e. Obter uma lista de todos os usuários que seguem um determinado vendedor [US 0003]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/users/{userId}/followers/list</td>
		</tr>
</table>

#### Paramêtros
<table>
	<th>Query param</th>
	<th>Valor</th>
		<tr>
			<td>order</td>
			<td>
				name_asc = alfabético crescente <br/>
				name_desc = alfabético decrescente
			</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
  "userId": 1,
  "userName": "Andre",
  "followers": [
    {
      "userId": 2,
      "userName": "Renan"
    }
  ]
}
```
<hr/>

### f. Obter uma lista de todos os vendedores que um determinado usuário segue [US 0004]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/users/{userId}/followed/list</td>
		</tr>
</table>

#### Paramêtros
<table>
	<th>Query param</th>
	<th>Valor</th>
		<tr>
			<td>order</td>
			<td>
				name_asc = alfabético crescente <br/>
				name_desc = alfabético decrescente
			</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
  "userId": 2,
  "userName": "Renan",
  "followed": [
    {
      "userId": 1,
      "userName": "Andre"
    }
  ]
}
```
<hr/>

## 2. Categorias
### a. Criar categoria
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/categories</td>
		</tr>
</table>

#### Request body
```javascript
{
	"name": "Livros"
}
```
#### Response
Success status: `201 Created`
```javascript
{
  "id": 1,
  "name": "Livros"
}
```
<hr/>

## 3. Publicações
### a. Criar publicação [US 0005]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/products/newpost</td>
		</tr>
</table>

#### Request body
```javascript
{
	"userId": 1,
	"id_post": 1,
	"date": "08-07-2021",
	"detail": {
		"product_id": 1,
		"productName": "Livro 1",
		"type": "Tipo",
		"brand": "Marca",
		"color": "Cor",
		"notes": "Observação",
		"category": 1,
		"price": 90
	}
}
```
#### Response
Success status: `201 Created`
<hr/>

### b. Obter uma lista das publicações feitas pelos vendedores que um usuário segue nas últimas duas semanas [US 0006]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/products/followed/{userId}/list</td>
		</tr>
</table>

#### Paramêtros
<table>
	<th>Query param</th>
	<th>Valor</th>
		<tr>
			<td>order</td>
			<td>
				date_asc = data crescente (do mais antigo para o mais novo) <br/>
				date_desc = data decrescente (do mais novo ao mais antigo)
			</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
  "userId": 2,
  "posts": [
    {
      "id_post": 1,
      "date": "08-07-2021",
      "detail": {
        "product_id": 1,
        "productName": "Livro 1",
        "type": "Tipo",
        "brand": "Marca",
        "color": "Cor",
        "notes": "Observação",
        "category": 1,
        "price": 90
      }
    }
  ]
}
```