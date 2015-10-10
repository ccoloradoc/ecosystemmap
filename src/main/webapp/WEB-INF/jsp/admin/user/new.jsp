 <form:form method="post" action="add" commandName="person" class="form-vertical">

    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName" />
    <form:label path="lastName">Last Name</form:label>
    <form:input path="lastName" />
    <input type="submit" value="Add Person" class="btn"/>
</form:form>