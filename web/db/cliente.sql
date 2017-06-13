-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.20 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura para tabela agilm.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(10) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Idade` int(3) unsigned NOT NULL,
  `Telefone` varchar(20) NOT NULL COMMENT 'fk',
  `Cidade` varchar(20) NOT NULL,
  `Bairro` varchar(20) NOT NULL COMMENT 'fk',
  `Endereco` varchar(30) NOT NULL COMMENT 'fk',
  `Complemento` varchar(35) DEFAULT NULL,
  `RG` varchar(12) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `Usuario` varchar(15) NOT NULL,
  `Senha` varchar(10) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
