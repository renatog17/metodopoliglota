package com.renato.projects.metodopoliglota.service.email.templates;

import com.renato.projects.metodopoliglota.service.email.EmailData;

public interface IEmailTemplate<T> {
    EmailData build(T context);
}
