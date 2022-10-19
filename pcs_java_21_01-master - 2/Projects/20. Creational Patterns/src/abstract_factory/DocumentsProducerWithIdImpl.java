package abstract_factory;

import java.util.UUID;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsProducerWithIdImpl implements DocumentsProducer {

    private static class ActImpl implements Act {
        private String id;

        public ActImpl(String id) {
            this.id = id;
        }

        @Override
        public String getDescription() {
            return "Act[id = " + id + "]";
        }
    }

    private static class StatementImpl implements Statement {
        private String id;

        public StatementImpl(String id) {
            this.id = id;
        }

        @Override
        public String getDescription() {
            return "Statement[id = " + id + "]";
        }
    }

    @Override
    public Act createAct() {
        return new ActImpl(UUID.randomUUID().toString());
    }

    @Override
    public Statement createStatement() {
        return new StatementImpl(UUID.randomUUID().toString());
    }
}
