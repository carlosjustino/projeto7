<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1599729054499" ID="ID_507408156" MODIFIED="1599729089979" TEXT="Projeto 7 - Lista de  Tarefas">
<node CREATED="1599729209246" FOLDED="true" ID="ID_423525813" MODIFIED="1599729219650" POSITION="right" TEXT="requisitos">
<node CREATED="1599729220510" ID="ID_1207912523" MODIFIED="1599729223538" TEXT="login">
<node CREATED="1599729307842" ID="ID_1171190202" MODIFIED="1599729325603" TEXT="">
<icon BUILTIN="idea"/>
<node CREATED="1599729326226" ID="ID_1238747603" MODIFIED="1599729335498" TEXT="Usu&#xe1;rio e senha"/>
<node CREATED="1599729336089" ID="ID_1731763270" MODIFIED="1599729341989" TEXT="bot&#xe3;o de se cadastrar ">
<node CREATED="1599729239821" ID="ID_1366561723" MODIFIED="1599729243303" TEXT="se cadastrar">
<node CREATED="1599729360620" ID="ID_271336949" MODIFIED="1599729367746" TEXT="Nome"/>
<node CREATED="1599729368245" ID="ID_1367765164" MODIFIED="1599729372645" TEXT="Usu&#xe1;rio"/>
<node CREATED="1599729373373" ID="ID_497889121" MODIFIED="1599729374673" TEXT="Senha"/>
</node>
</node>
<node CREATED="1599729342577" ID="ID_1213359097" MODIFIED="1599729350633" TEXT="bot&#xe3;o de logar "/>
</node>
</node>
<node CREATED="1599729224074" ID="ID_1611606052" MODIFIED="1599729227878" TEXT="tarefas">
<node CREATED="1599729655656" ID="ID_1804200467" MODIFIED="1599729662680" TEXT="tarefas s&#xe3;o para os usuarios"/>
<node CREATED="1599729663164" ID="ID_1777809062" MODIFIED="1599729672692" TEXT="ao incluir seta a data de inclusao"/>
<node CREATED="1599729673024" ID="ID_1028561487" MODIFIED="1599729683260" TEXT="sera guardado um historico de alteracao "/>
<node CREATED="1599729684628" ID="ID_1151224500" MODIFIED="1599729702200" TEXT="deve gerar a statistica por usuario e tarefa">
<node CREATED="1599729702943" ID="ID_618930483" MODIFIED="1599729711228" TEXT="quantas tarefas o usuario concluiu no dia"/>
<node CREATED="1599729711848" ID="ID_488234998" MODIFIED="1599729724273" TEXT="quantas tarefas o usuario incluiu no dia"/>
<node CREATED="1599729725076" ID="ID_777828981" MODIFIED="1599729743076" TEXT="quantas tarefas diferentes foram alteradas"/>
<node CREATED="1599729743587" ID="ID_1690469026" MODIFIED="1599729782456" TEXT="qual a media de vezes q uma mesma tarefa foi alterada"/>
</node>
</node>
<node CREATED="1599729228503" ID="ID_1302404956" MODIFIED="1599729232002" TEXT="lista de tarefas"/>
<node CREATED="1599729233127" ID="ID_1629495480" MODIFIED="1599729236550" TEXT="marcar como concluido"/>
</node>
<node CREATED="1599729388685" FOLDED="true" ID="ID_1570536553" MODIFIED="1599731400498" POSITION="right" TEXT="entidades">
<node CREATED="1599729393889" ID="ID_1074234216" MODIFIED="1599729398125" TEXT="usuario">
<node CREATED="1599729505318" ID="ID_319179289" MODIFIED="1599729507669" TEXT="atributos">
<node CREATED="1599729444064" ID="ID_1072329490" MODIFIED="1599729445829" TEXT="nome"/>
<node CREATED="1599729446569" ID="ID_381656814" MODIFIED="1599729456321" TEXT="login">
<node CREATED="1599729487801" ID="ID_1807352112" MODIFIED="1599729489433" TEXT="unico"/>
</node>
<node CREATED="1599729457569" ID="ID_1328586708" MODIFIED="1599729458509" TEXT="email">
<node CREATED="1599729483933" ID="ID_1753530604" MODIFIED="1599729486001" TEXT="validar"/>
</node>
<node CREATED="1599729459173" ID="ID_167333211" MODIFIED="1599729462093" TEXT="senha">
<node CREATED="1599729469012" ID="ID_158477162" MODIFIED="1599729478889" TEXT="hash"/>
</node>
</node>
</node>
<node CREATED="1599729399164" ID="ID_495720971" MODIFIED="1599729402149" TEXT="tarefas">
<node CREATED="1599729505318" ID="ID_1610368458" MODIFIED="1599729507669" TEXT="atributos">
<node CREATED="1599730826895" ID="ID_1147690988" MODIFIED="1599730829416" TEXT="numero">
<node CREATED="1599730830002" ID="ID_484969036" MODIFIED="1599730832972" TEXT="gerado automatico"/>
</node>
<node CREATED="1599729444064" ID="ID_509489075" MODIFIED="1599729526092" TEXT="titulo"/>
<node CREATED="1599729527725" ID="ID_1117043704" MODIFIED="1599729574189" TEXT="descricao"/>
<node CREATED="1599729446569" ID="ID_1670458100" MODIFIED="1599729601136" TEXT="usuario"/>
<node CREATED="1599729618913" ID="ID_181257537" MODIFIED="1599729621192" TEXT="datainclusao"/>
</node>
</node>
<node CREATED="1599729625868" ID="ID_1930916070" MODIFIED="1599729809165" TEXT="tarefaalteracao">
<node CREATED="1599729505318" ID="ID_675678387" MODIFIED="1599729507669" TEXT="atributos">
<node CREATED="1599729444064" ID="ID_96096027" MODIFIED="1599729817016" TEXT="tarefa"/>
<node CREATED="1599729527725" ID="ID_200483339" MODIFIED="1599729574189" TEXT="descricao"/>
<node CREATED="1599729618913" ID="ID_431212880" MODIFIED="1599729858467" TEXT="datamovimento"/>
<node CREATED="1599729859455" ID="ID_1232040317" MODIFIED="1599729876659" TEXT="tipomovimento">
<node CREATED="1599729877275" ID="ID_628395958" MODIFIED="1599729885364" TEXT="1 - inclusao"/>
<node CREATED="1599729886035" ID="ID_786364088" MODIFIED="1599729890867" TEXT="2 - alteracao"/>
<node CREATED="1599729891464" ID="ID_564099" MODIFIED="1599729894615" TEXT="3 - conclusao"/>
</node>
</node>
</node>
<node CREATED="1599729402577" ID="ID_1624903018" MODIFIED="1599729411749" TEXT="statisticas">
<node CREATED="1599729905275" ID="ID_1580533794" MODIFIED="1599729909563" TEXT="atributos">
<node CREATED="1599729910244" ID="ID_1049154486" MODIFIED="1599729920115" TEXT="datareferencia"/>
<node CREATED="1599729921015" ID="ID_470995216" MODIFIED="1599729927371" TEXT="usuario"/>
<node CREATED="1599729927799" ID="ID_1295153549" MODIFIED="1599730180750" TEXT="qtdtarefaconcluidadia"/>
<node CREATED="1599730182331" ID="ID_1710722160" MODIFIED="1599730190670" TEXT="qtdtarefaincluidadia"/>
<node CREATED="1599730191606" ID="ID_1511455862" MODIFIED="1599730198631" TEXT="qtdtarefaalteradas"/>
<node CREATED="1599730225441" ID="ID_95029864" MODIFIED="1599730235238" TEXT="mediaalteracaounicatarefa"/>
</node>
</node>
</node>
<node CREATED="1599730251090" FOLDED="true" ID="ID_1573044187" MODIFIED="1599730256579" POSITION="right" TEXT="funcionamento">
<node CREATED="1599730325069" ID="ID_390696848" MODIFIED="1599730341669" TEXT="ao acessar a aplica&#xe7;&#xe3;o cai na tela de login"/>
<node CREATED="1599730342256" ID="ID_285016803" MODIFIED="1599730369781" TEXT="o usuario pode">
<node CREATED="1599730370177" ID="ID_466063857" MODIFIED="1599730372049" TEXT="cadastrar">
<node CREATED="1599730595356" ID="ID_240835202" MODIFIED="1599730602085" TEXT="vai para a tela de cadastro de usuario">
<node CREATED="1599730602897" ID="ID_1773349771" MODIFIED="1599730612513" TEXT="valida dados unicos antes de chegar no banco "/>
<node CREATED="1599730616899" ID="ID_857690395" MODIFIED="1599730637413" TEXT="salva e direciona para a tela de listagem de tarefas"/>
</node>
</node>
<node CREATED="1599730372512" ID="ID_840613227" MODIFIED="1599730594313" TEXT="efetuar login">
<node CREATED="1599730640068" ID="ID_152867055" MODIFIED="1599730648560" TEXT="direciona para a tela de listagem de tarefas"/>
</node>
</node>
<node CREATED="1599730657608" ID="ID_228250539" MODIFIED="1599730663704" TEXT="na tela de listagem de tarefas">
<node CREATED="1599730665086" ID="ID_1162223430" MODIFIED="1599730673628" TEXT="o usuario pode editar uma tarefa"/>
<node CREATED="1599730674064" ID="ID_372543315" MODIFIED="1599730678080" TEXT="adicionar uma tarefa"/>
<node CREATED="1599730766616" ID="ID_1999173711" MODIFIED="1599730786080" TEXT="opcao para mostrar por">
<node CREATED="1599730787043" ID="ID_1219166941" MODIFIED="1599730792124" TEXT="range de data"/>
<node CREATED="1599730792523" ID="ID_348258031" MODIFIED="1599730797684" TEXT="concluidas">
<node CREATED="1599730798288" ID="ID_718306809" MODIFIED="1599730799412" TEXT="sim "/>
<node CREATED="1599730800019" ID="ID_1247497613" MODIFIED="1599730803188" TEXT="n&#xe3;o"/>
</node>
</node>
</node>
<node CREATED="1599730713579" ID="ID_1582416212" MODIFIED="1599730726689" TEXT="cada a&#xe7;&#xe3;o do usu&#xe1;rio atualiza a estatistica "/>
</node>
<node CREATED="1599731316713" ID="ID_950992136" MODIFIED="1599731320434" POSITION="right" TEXT="tecnologias">
<node CREATED="1599731321409" ID="ID_396687400" MODIFIED="1599731322782" TEXT="java 8"/>
<node CREATED="1599731323310" ID="ID_661106831" MODIFIED="1599731333362" TEXT="quarkus">
<node CREATED="1599814449827" LINK="https://quarkus.io/guides/validation" MODIFIED="1599814449827" TEXT="https://quarkus.io/guides/validation"/>
</node>
<node CREATED="1599731353041" ID="ID_431457728" MODIFIED="1599731356894" TEXT="Angular 7"/>
<node CREATED="1599731357310" ID="ID_1743641202" MODIFIED="1599731358618" TEXT="Swarm"/>
<node CREATED="1599731361981" ID="ID_1210109099" MODIFIED="1599731366741" TEXT="postgresql"/>
</node>
<node CREATED="1599813554864" ID="ID_1767133741" MODIFIED="1599813557625" POSITION="right" TEXT="proposta">
<node CREATED="1599813558516" ID="ID_4513542" MODIFIED="1599813564640" TEXT="container backend"/>
<node CREATED="1599813565012" ID="ID_768636439" MODIFIED="1599813567812" TEXT="container frontend"/>
<node CREATED="1599813569196" ID="ID_733853735" MODIFIED="1599813582112" TEXT="container database"/>
</node>
</node>
</map>
