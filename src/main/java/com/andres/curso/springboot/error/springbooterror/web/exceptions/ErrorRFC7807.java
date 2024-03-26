package com.andres.curso.springboot.error.springbooterror.web.exceptions;

import java.util.Date;

public record ErrorRFC7807 (
        String title,

        String detail,

        String type,

        int status,

        Date then
) { }
