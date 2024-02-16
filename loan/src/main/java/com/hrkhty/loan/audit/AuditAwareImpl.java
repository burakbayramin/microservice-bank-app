package com.hrkhty.loan.audit;

import org.hibernate.annotations.Comment;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Comment("AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOAN_SERVICE");
    }
}
