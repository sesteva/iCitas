package com.icitas

class Agenda {
	
    static constraints = {
    }
	
	static hasMany = [citas:Cita]
	
	static belongsTo = [profesional:Profesional]
	
	String toString(){
		"${this.profesional.nombre}"
	}
}
