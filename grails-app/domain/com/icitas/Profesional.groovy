package com.icitas

class Profesional extends Usuario{
	
	String departamento
	String profesion
	String especialidad
	
	Agenda agenda = new Agenda()
	

    static constraints = {
    }
}
