public class ContaBanco {
    public int numConta;
    protected char tipoConta;
    private String donoConta;
    private float saldoConta;
    private boolean statusConta;

    public ContaBanco(int numConta, char tipoConta, String donoConta) {
        setNumConta(numConta);
        setTipoConta(tipoConta);
        setDonoConta(donoConta);
        setSaldoConta(0.0f);
        setStatusConta(true);
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public char getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(char tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDonoConta() {
        return this.donoConta;
    }

    public void setDonoConta(String donoConta) {
        this.donoConta = donoConta;
    }

    public float getSaldoConta() {
        return this.saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }

    public boolean getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    public void fecharConta() {
        if (getSaldoConta() > 0) {
            System.out.println("ERRO: Não é possível fechar uma conta que contém saldo");
        }
        else {
            setStatusConta(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void reativarConta() {
        if (getStatusConta()) {
            System.out.println("ERRO: Essa conta já está ativa");
        }
        else {
            setStatusConta(true);
            System.out.println("Conta reativada com sucesso!");
        }
    }

    public void depositarConta(float valorDeposito) {
        if (getStatusConta()) {
            setSaldoConta((this.saldoConta += valorDeposito));
            System.out.println("Depósito realizado com sucesso!");
        }
        else {
            System.out.println("ERRO: Não é possível depositar, essa conta está fechada!");
        }
    }

    public void sacarConta(float valorSaque) {
        if (!getStatusConta()) {
            System.out.println("ERRO: Não é possível sacar, essa conta está fechada");
        }
        else {
            if (valorSaque > getSaldoConta()) {
                System.out.println("ERRO: Saldo insuficiente");
            }

            else {
                if (valorSaque <= 0.0f) {
                    System.out.println("ERRO: Insira um valor maior que zero");
                }
                else {
                    setSaldoConta((this.saldoConta -= valorSaque));
                    System.out.println("Saque realizado com sucesso!");
                }
            }

        }
    }

    public void consultaConta() {
        System.out.printf(
                "Consulta de conta:%n%n" +
                "Número da conta: %d%n" +
                "Tipo de conta: %c%n" +
                "Titular da conta: %s%n" +
                "Saldo da conta: %.2f%n" +
                "Status da conta: %b%n",
                getNumConta(),
                getTipoConta(),
                getDonoConta(),
                getSaldoConta(),
                getStatusConta()
        );
    }
}