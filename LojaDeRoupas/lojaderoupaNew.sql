-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Dez-2018 às 04:26
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lojaderoupa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--
#create database lojaderoupaNew;

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `dataNascimento` varchar(8) NOT NULL,
  `estadoCivil` varchar(15) NOT NULL,
  `tipoEndereco` varchar(10) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `numeroResidencia` int(11) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `bairro` varchar(65) NOT NULL,
  `complemento` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table login(
	idlogin int(11) not null auto_increment,
    usuario varchar(45) not null,
    senha varchar(45) not null,
    primary key(idlogin)
);

--
-- Estrutura da tabela `itemvenda`
--

CREATE TABLE `itemvenda` (
  `idItemVenda` int(11) NOT NULL,
  `Produto` varchar(200) DEFAULT NULL,
  `idVenda` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `valorUnitario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `tamanho` varchar(5) NOT NULL,
  `cor` varchar(15) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valorUnitario` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--



--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `nomeCliente` varchar(100) DEFAULT NULL,
  `idvenda` int(11) NOT NULL,
  `valorTotalPagar` double NOT NULL,
  `dataCompra` varchar(50) NOT NULL,
  `cpfCliente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--



--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indexes for table `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD PRIMARY KEY (`idItemVenda`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idvenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `itemvenda`
--
ALTER TABLE `itemvenda`
  MODIFY `idItemVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `idvenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

use lojaderoupaNew;
alter table `cliente` modify `dataNascimento` varchar(15) not null;