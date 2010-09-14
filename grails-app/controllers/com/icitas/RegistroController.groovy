package com.icitas

class RegistroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [registroInstanceList: Registro.list(params), registroInstanceTotal: Registro.count()]
    }

    def create = {
        def registroInstance = new Registro()
        registroInstance.properties = params
        return [registroInstance: registroInstance]
    }

    def save = {
        def registroInstance = new Registro(params)
        if (registroInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'registro.label', default: 'Registro'), registroInstance.id])}"
            redirect(action: "show", id: registroInstance.id)
        }
        else {
            render(view: "create", model: [registroInstance: registroInstance])
        }
    }

    def show = {
        def registroInstance = Registro.get(params.id)
        if (!registroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
            redirect(action: "list")
        }
        else {
            [registroInstance: registroInstance]
        }
    }

    def edit = {
        def registroInstance = Registro.get(params.id)
        if (!registroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [registroInstance: registroInstance]
        }
    }

    def update = {
        def registroInstance = Registro.get(params.id)
        if (registroInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (registroInstance.version > version) {
                    
                    registroInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'registro.label', default: 'Registro')] as Object[], "Another user has updated this Registro while you were editing")
                    render(view: "edit", model: [registroInstance: registroInstance])
                    return
                }
            }
            registroInstance.properties = params
            if (!registroInstance.hasErrors() && registroInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'registro.label', default: 'Registro'), registroInstance.id])}"
                redirect(action: "show", id: registroInstance.id)
            }
            else {
                render(view: "edit", model: [registroInstance: registroInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def registroInstance = Registro.get(params.id)
        if (registroInstance) {
            try {
                registroInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'registro.label', default: 'Registro'), params.id])}"
            redirect(action: "list")
        }
    }
}
