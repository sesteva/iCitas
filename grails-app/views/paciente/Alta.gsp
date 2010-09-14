<div id="alta">
	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
    </g:if>
	<g:hasErrors bean="${paciente}">
        <div class="errors">
	        <g:renderErrors bean="${paciente}" as="list" />
	    </div>
   	</g:hasErrors>
	<h3>Nuevo Paciente</h3>
	<div id="altaForm">
		<g:form action="crear">
			<ul>
				<li>Nombre <g:textField name="nombre" value="${paciente?.nombre}"/></li>
				<li>Apellido <g:textField name="apellido" value="${paciente?.apellido}"/> </li>
				<li>
					<g:select name="edad" from="${1..100}" value="${paciente?.edad}"/>
				</li>
				<li>Correo Electronico <g:textField name="email" value="${paciente?.email}"/> </li>
				<li>Telefono <g:textField name="telefono" value="${paciente?.telefono}"/> </li>
				<li>Extension <g:textField name="extension" value="${paciente?.extension}"/> </li>
			</ul>
			<g:submitButton name="crear"/> 
		</g:form>
	</div>

</div>