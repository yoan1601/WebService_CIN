namespace TodoApi.Models
{
    public class Transaction
    {
        public string? idTransaction { get; set; }
        public string? nomBanque { get; set; }
        public double? depot { get; set; }
        public double? retrait { get; set; }
        public string? dateHeureTransaction { get; set; }

        public static Transaction[] ConsulteTransactions(string idCIN)
        {
            Transaction t1 = new Transaction { 
                idTransaction = "1",
                nomBanque = "BNI MDG",
                depot = 0,
                retrait = 800,
                dateHeureTransaction = "16/01/2003 10:00:00"};

            Transaction t2 = new Transaction
            {
                idTransaction = "2",
                nomBanque = "ENJANA",
                depot = 2050,
                retrait = 0,
                dateHeureTransaction = "17/01/2003 10:00:00"
            };

            Transaction t3 = new Transaction
            {
                idTransaction = "3",
                nomBanque = "BOA MDG",
                depot = 0,
                retrait = 20000,
                dateHeureTransaction = "16/01/2003 10:00:00"
            };

            Transaction[] transactions = { t1, t2, t3 };
            return transactions;
        }
    }
}
