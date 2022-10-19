package abstract_factory;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsProducerWithDateImpl implements DocumentsProducer {
    private static class ActImpl implements Act {
        private LocalDate date;

        public ActImpl(LocalDate date) {
            this.date = date;
        }

        @Override
        public String getDescription() {
            return "Act[date = " + date + "]";
        }
    }

    private static class StatementImpl implements Statement {
        private LocalDate date;

        public StatementImpl(LocalDate date) {
            this.date = date;
        }

        @Override
        public String getDescription() {
            return "Statement[date = " + date + "]";
        }
    }

    @Override
    public Act createAct() {
        return new ActImpl(LocalDate.now());
    }

    @Override
    public Statement createStatement() {
        return new StatementImpl(LocalDate.now());
    }
}
