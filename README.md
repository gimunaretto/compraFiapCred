# CARTÃO - FIAP

## Avaliação Spring
___


<p>
    <h3 align=center><b>Tecnologias do projeto:</b></h3>
    <li>SpringBoot 2.7.9</li>
    <li>Java 11</li>
    <li>Docker - Mysql</li>
    <li>Documentação Swagger</li>
</p>

<h3 align=center><b>Start do Servidor MySql:</b></h3>

    O banco de dados - Mysql - foi instalado em um Docker.
    Para inicializar, abrir o terminal dentro na pasta do projeto
    Para início do projeto:
        1) docker-compose up => Inicializa o Docker com o MySql;
        2) Entrar no link e rodar os request:
            "http://localhost:8084/swagger-ui/index.html"


<h3 align=center><b>Funcionalidades:</b></h3>

<p>
 <b>Crud de Alunos:</b>
    <li>post (/alunos/cadastrarAluno) - Faz upload do arquivo txt e cria todos os alunos</li>
    <li>post (/alunos/{id}/comprar) - cadastra uma compra do aluno</li>
    <li>get (/alunos/{id}/extrato) - Gera um extrato com as compras do aluno</li>
    <li>get (/alunos/listarAlunos) - Retorna uma lista paginada com todos os alunos. 
    <li>get (/alunos/filtrarAlunoPorId/{id}) - Retorna o aluno pelo id</li>
    <li>put (/alunos/atualizarAluno/{id}) - Atualiza o aluno pelo id</li>
    <li>delete (/alunos/deletarAluno/{id}) - Realiza o soft delete do aluno pelo id</li>
</p>

