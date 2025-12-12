# Sistema de Cálculo de CR (Coeficiente de Rendimento)

Projeto de um ambiente colegial com registro de alunos, cursos e 
disciplinas desenvolvido em **Java** com **SpringBoot**, implementado para o Desafio 3 do processo de estágio STI.
## Como Executar

```bash
mvn spring-boot:run
```

## Interface Web Simples de Exemplo

Após executar a aplicação, você poderá vizualizar a listagem dos 
CRs dos alunos e dos cursos no próprio **Console** ou acessando em seu navegador:

- `http://localhost:8080/`

## Cálculo dos CRs

Cálculo do CR feito com a fórmula padrão utilizada pela UFF:

```
CR = Σ(Nota(i) * CargaHoraria(i)) / Σ(CargaHoraria(i))
```

## Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.0
- Thymeleaf (para interface web simplificada de exemplo)
- Maven