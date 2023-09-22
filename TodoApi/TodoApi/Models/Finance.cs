namespace TodoApi.Models
{
    public class Finance
    {
        public Banque? banque { get; set; }
        public Transaction []? transactions { get; set; }

        public static Finance ConsulteFinance(string idCIN)
        {
            Finance f = new Finance();
            Banque banque= Banque.ConsulteBanque(idCIN);
            Transaction[] lTransactions = Transaction.ConsulteTransactions(idCIN);
            f.banque = banque;
            f.transactions = lTransactions;
            return f;
        }
    }
}
