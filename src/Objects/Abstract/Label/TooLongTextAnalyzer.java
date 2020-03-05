package Objects.Abstract.Label;

public class TooLongTextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int length) {
        this.maxLength = length;
    }

    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }


    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer anal : analyzers) {
            Label result;
            if ((result = anal.processText(text)) != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }
}