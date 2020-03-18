class IntegerToEnglishWords {
  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
      "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS =
      {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

//i.e 12, 594
  // We need to get the 12 by 12594 / 1000
  // The last 3 digits: 12594 % 1000
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    StringBuilder word = new StringBuilder();
    int index = 0;

    // while loop to append the big units at front
    while (num > 0) {
      if (num % 1000 != 0) {
        word.insert(0, parseThreeDigits(num % 1000) + THOUSANDS[index] + " ");
      }

      num = num / 1000;
      index++;
    }
    return word.toString().trim();
  }

  public String parseThreeDigits(int num) {
    if (num <= 0) {
      return "";
    } else if (num < 20) {
      return LESS_THAN_20[num] + " ";
    } else if (num < 100) {
      return TENS[num / 10] + " " + parseThreeDigits(num % 10);
    } else {
      return LESS_THAN_20[num / 100] + " Hundred " + parseThreeDigits(num % 100);
    }
  }
}
