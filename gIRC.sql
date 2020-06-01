-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;


-- ************************************** "irc"."usuario"

CREATE TABLE "irc"."usuario"
(
 "id"    serial NOT NULL,
 "nome"  character varying(50) NOT NULL,
 "senha" character varying(8) NOT NULL,
 CONSTRAINT "PK_usuario" PRIMARY KEY ( "id" )
);



-- ************************************** "irc"."sala_principal"

CREATE TABLE "irc"."sala_principal"
(
 "id"       serial NOT NULL,
 "mensagem" character varying(100) NOT NULL,
 "usuario"  integer NOT NULL,
 CONSTRAINT "PK_sala_principal" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_17" FOREIGN KEY ( "usuario" ) REFERENCES "irc"."usuario" ( "id" )
);

CREATE INDEX "fkIdx_17" ON "irc"."sala_principal"
(
 "usuario"
);







