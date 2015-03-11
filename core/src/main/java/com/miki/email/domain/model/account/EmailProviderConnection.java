package com.miki.email.domain.model.account;

import com.miki.email.domain.model.ValueObject;
import com.miki.email.domain.model.account.exceptions.InvalidConnectionParamException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by miki on 10.03.2015.
 */
public final class EmailProviderConnection implements ValueObject<EmailProviderConnection> {

    private String host;
    private Integer port;

    public EmailProviderConnection() {
    }


    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailProviderConnection that = (EmailProviderConnection) o;

        return sameValueAs(that);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getHost())
                .append(this.getPort())
                .toHashCode();
    }

    @Override
    public boolean sameValueAs(EmailProviderConnection other) {
        return other != null && new EqualsBuilder()
                .append(this.getHost(), other.getHost())
                .append(this.getPort(), other.getPort())
                .build();
    }

    public static class Builder {

        private EmailProviderConnection emailProviderConnection;

        public Builder() {
            this.emailProviderConnection = new EmailProviderConnection();
        }

        public Builder withHost(String host) {
            this.emailProviderConnection.host = host;
            return this;
        }

        public Builder withPort(Integer port) {
            this.emailProviderConnection.port = port;
            return this;
        }

        public EmailProviderConnection build() throws InvalidConnectionParamException {
            if (StringUtils.isEmpty(this.emailProviderConnection.getHost())) {
                throw new InvalidConnectionParamException(this.emailProviderConnection.getHost());
            }
            if (this.emailProviderConnection.getPort() == null || this.emailProviderConnection.getPort() < 1) {
                throw new InvalidConnectionParamException("port");

            }
            return this.emailProviderConnection;
        }

    }
}
