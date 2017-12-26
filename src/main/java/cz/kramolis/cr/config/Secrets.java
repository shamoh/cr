package cz.kramolis.cr.config;

import java.util.Objects;

public class Secrets {

    private final String crApiAuthHeader;

    private Secrets(Builder builder) {
        this.crApiAuthHeader = builder.crApiAuthHeader;
    }

    public String getCrApiAuthHeader() {
        return crApiAuthHeader;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String crApiAuthHeader;

        private Builder() {
        }

        public Builder crApiAuthHeader(String crApiAuthHeader) {
            this.crApiAuthHeader = crApiAuthHeader;

            return this;
        }

        public Secrets build() {
            Objects.requireNonNull(crApiAuthHeader, "Missing mandatory 'crApiAuthHeader'.");

            return new Secrets(this);
        }
    }

}
