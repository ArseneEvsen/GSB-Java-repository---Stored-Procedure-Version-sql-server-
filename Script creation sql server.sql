USE [GSBjava]
GO
/****** Object:  Schema [gsbjava]    Script Date: 03/04/2023 11:44:16 ******/
CREATE SCHEMA [gsbjava]
GO
/****** Object:  Table [gsbjava].[localite]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[localite](
	[CODEPOSTAL] [char](5) NOT NULL,
	[VILLE] [varchar](50) NULL,
 CONSTRAINT [PK_localite_CODEPOSTAL] PRIMARY KEY CLUSTERED 
(
	[CODEPOSTAL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[mdpVisiteur]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[mdpVisiteur](
	[MATRICULE] [char](4) NOT NULL,
	[MDP] [varchar](20) NOT NULL,
	[DATE] [date] NOT NULL,
 CONSTRAINT [PK_mdpVisiteur] PRIMARY KEY CLUSTERED 
(
	[MATRICULE] ASC,
	[MDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[medecin]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[medecin](
	[CODEMED] [char](4) NOT NULL,
	[NOM] [varchar](50) NULL,
	[PRENOM] [varchar](50) NULL,
	[ADRESSE] [varchar](50) NULL,
	[CODEPOSTAL] [varchar](5) NULL,
	[TELEPHONE] [varchar](15) NULL,
	[POTENTIEL] [varchar](50) NULL,
	[SPECIALITE] [varchar](50) NULL,
 CONSTRAINT [PK_medecin_CODEMED] PRIMARY KEY CLUSTERED 
(
	[CODEMED] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[medicament]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[medicament](
	[MED_DEPOTLEGAL] [varchar](10) NOT NULL,
	[MED_NOMCOMMERCIAL] [varchar](25) NULL,
	[MED_COMPOSITION] [varchar](255) NULL,
	[MED_EFFETS] [varchar](255) NULL,
	[MED_CONTREINDIC] [varchar](255) NULL,
	[MED_PRIXECHANTILLON] [real] NULL,
	[FAM_CODE] [varchar](3) NULL,
	[FAM_LIBELLE] [varchar](80) NULL,
 CONSTRAINT [PK_medicament_MED_DEPOTLEGAL] PRIMARY KEY CLUSTERED 
(
	[MED_DEPOTLEGAL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[responsable]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[responsable](
	[visiteur_responsable] [char](4) NOT NULL,
	[visiteur] [char](4) NOT NULL,
 CONSTRAINT [PK_Visiteur] PRIMARY KEY CLUSTERED 
(
	[visiteur] ASC,
	[visiteur_responsable] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[stock]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[stock](
	[QTESTOCK] [bigint] NULL,
	[MATRICULE] [char](4) NOT NULL,
	[MED_DEPOTLEGAL] [varchar](10) NOT NULL,
 CONSTRAINT [PK_stock_MATRICULE] PRIMARY KEY CLUSTERED 
(
	[MATRICULE] ASC,
	[MED_DEPOTLEGAL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[visite]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[visite](
	[REFERENCE] [char](5) NOT NULL,
	[DATEVISITE] [char](10) NULL,
	[COMMENTAIRE] [varchar](100) NULL,
	[MATRICULE] [char](4) NOT NULL,
	[CODEMED] [char](4) NOT NULL,
 CONSTRAINT [PK_visite_REFERENCE] PRIMARY KEY CLUSTERED 
(
	[REFERENCE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [gsbjava].[visiteur]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [gsbjava].[visiteur](
	[MATRICULE] [char](4) NOT NULL,
	[NOM] [varchar](50) NULL,
	[PRENOM] [varchar](50) NULL,
	[LOGIN] [varchar](50) NULL,
	[MDP] [varchar](20) NULL,
	[ADRESSE] [varchar](50) NULL,
	[CODEPOSTAL] [char](5) NOT NULL,
	[DATEENTREE] [datetime2](0) NULL,
	[CODEUNIT] [char](4) NOT NULL,
	[NOMUNIT] [varchar](50) NULL,
	[TELEPHONE] [char](10) NULL,
	[PRIME] [int] NULL,
	[DATE_EXP] [date] NOT NULL,
	[EXPIRE] [bit] NOT NULL,
 CONSTRAINT [PK_visiteur_MATRICULE] PRIMARY KEY CLUSTERED 
(
	[MATRICULE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [gsbjava].[localite] ADD  DEFAULT (NULL) FOR [VILLE]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [NOM]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [PRENOM]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [ADRESSE]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [CODEPOSTAL]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [TELEPHONE]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [POTENTIEL]
GO
ALTER TABLE [gsbjava].[medecin] ADD  DEFAULT (NULL) FOR [SPECIALITE]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (N'') FOR [MED_DEPOTLEGAL]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [MED_NOMCOMMERCIAL]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [MED_COMPOSITION]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [MED_EFFETS]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [MED_CONTREINDIC]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [MED_PRIXECHANTILLON]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [FAM_CODE]
GO
ALTER TABLE [gsbjava].[medicament] ADD  DEFAULT (NULL) FOR [FAM_LIBELLE]
GO
ALTER TABLE [gsbjava].[stock] ADD  CONSTRAINT [DF__stock__QTESTOCK__76969D2E]  DEFAULT (NULL) FOR [QTESTOCK]
GO
ALTER TABLE [gsbjava].[visite] ADD  DEFAULT (NULL) FOR [DATEVISITE]
GO
ALTER TABLE [gsbjava].[visite] ADD  DEFAULT (NULL) FOR [COMMENTAIRE]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__NOM__797309D9]  DEFAULT (NULL) FOR [NOM]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__PRENOM__7A672E12]  DEFAULT (NULL) FOR [PRENOM]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__LOGIN__7B5B524B]  DEFAULT (NULL) FOR [LOGIN]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__MDP__7C4F7684]  DEFAULT (NULL) FOR [MDP]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__ADRESS__7D439ABD]  DEFAULT (NULL) FOR [ADRESSE]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__CODEPO__7E37BEF6]  DEFAULT (NULL) FOR [CODEPOSTAL]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__DATEEN__7F2BE32F]  DEFAULT (NULL) FOR [DATEENTREE]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__NOMUNI__00200768]  DEFAULT (NULL) FOR [NOMUNIT]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__TELEPH__01142BA1]  DEFAULT (NULL) FOR [TELEPHONE]
GO
ALTER TABLE [gsbjava].[visiteur] ADD  CONSTRAINT [DF__visiteur__PRIME__02084FDA]  DEFAULT (NULL) FOR [PRIME]
GO
ALTER TABLE [gsbjava].[mdpVisiteur]  WITH CHECK ADD  CONSTRAINT [FK_Visiteur_mdpVisiteur] FOREIGN KEY([MATRICULE])
REFERENCES [gsbjava].[visiteur] ([MATRICULE])
GO
ALTER TABLE [gsbjava].[mdpVisiteur] CHECK CONSTRAINT [FK_Visiteur_mdpVisiteur]
GO
ALTER TABLE [gsbjava].[responsable]  WITH CHECK ADD  CONSTRAINT [FK_responsable_visiteur] FOREIGN KEY([visiteur])
REFERENCES [gsbjava].[visiteur] ([MATRICULE])
GO
ALTER TABLE [gsbjava].[responsable] CHECK CONSTRAINT [FK_responsable_visiteur]
GO
ALTER TABLE [gsbjava].[responsable]  WITH CHECK ADD  CONSTRAINT [FK_responsable_visiteurResponsable] FOREIGN KEY([visiteur_responsable])
REFERENCES [gsbjava].[visiteur] ([MATRICULE])
GO
ALTER TABLE [gsbjava].[responsable] CHECK CONSTRAINT [FK_responsable_visiteurResponsable]
GO
ALTER TABLE [gsbjava].[stock]  WITH CHECK ADD  CONSTRAINT [FK_medicament_stock] FOREIGN KEY([MED_DEPOTLEGAL])
REFERENCES [gsbjava].[medicament] ([MED_DEPOTLEGAL])
GO
ALTER TABLE [gsbjava].[stock] CHECK CONSTRAINT [FK_medicament_stock]
GO
ALTER TABLE [gsbjava].[stock]  WITH CHECK ADD  CONSTRAINT [stock$MATRICULE_VISI] FOREIGN KEY([MATRICULE])
REFERENCES [gsbjava].[visiteur] ([MATRICULE])
GO
ALTER TABLE [gsbjava].[stock] CHECK CONSTRAINT [stock$MATRICULE_VISI]
GO
ALTER TABLE [gsbjava].[visite]  WITH CHECK ADD  CONSTRAINT [visite$VISITE_ibfk_1] FOREIGN KEY([MATRICULE])
REFERENCES [gsbjava].[visiteur] ([MATRICULE])
GO
ALTER TABLE [gsbjava].[visite] CHECK CONSTRAINT [visite$VISITE_ibfk_1]
GO
ALTER TABLE [gsbjava].[visite]  WITH CHECK ADD  CONSTRAINT [visite$VISITE_ibfk_2] FOREIGN KEY([CODEMED])
REFERENCES [gsbjava].[medecin] ([CODEMED])
GO
ALTER TABLE [gsbjava].[visite] CHECK CONSTRAINT [visite$VISITE_ibfk_2]
GO
ALTER TABLE [gsbjava].[visiteur]  WITH CHECK ADD  CONSTRAINT [visiteur$VISITEUR_ibfk_1] FOREIGN KEY([CODEPOSTAL])
REFERENCES [gsbjava].[localite] ([CODEPOSTAL])
GO
ALTER TABLE [gsbjava].[visiteur] CHECK CONSTRAINT [visiteur$VISITEUR_ibfk_1]
GO
/****** Object:  StoredProcedure [dbo].[ajouterMdpVisiteur]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ajouterMdpVisiteur]
    @matricule VARCHAR(50),
    @mdp VARCHAR(50)
AS
BEGIN
    INSERT INTO gsbjava.mdpVisiteur (MATRICULE, MDP, DATE)
    VALUES (@matricule, @mdp, GETDATE())
END
GO
/****** Object:  StoredProcedure [dbo].[ajouterResponsable]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ajouterResponsable]
@visiteur_responsable char(4),
@visiteur char(4)
AS
BEGIN
BEGIN TRY
INSERT INTO gsbjava.responsable (visiteur_responsable, visiteur)
VALUES (@visiteur_responsable, @visiteur)
END TRY
BEGIN CATCH
DECLARE @errorMessage NVARCHAR(1000) = ERROR_MESSAGE()
RAISERROR(@errorMessage, 16, 1)
END CATCH
END
GO
/****** Object:  StoredProcedure [dbo].[ajouterVisiteur]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ajouterVisiteur]
    @matricule VARCHAR(50),
    @nom VARCHAR(50),
    @prenom VARCHAR(50),
    @login VARCHAR(50),
    @mdp VARCHAR(50),
    @adresse VARCHAR(50),
    @codepostal VARCHAR(10),
    @dateentree DATE,
    @codeunit VARCHAR(50),
    @nomunit VARCHAR(50),
    @telephone VARCHAR(20),
    @prime DECIMAL(18,2)
AS
BEGIN
    DECLARE @dateExp DATE = DATEADD(DAY, 100, GETDATE())
    DECLARE @expire BIT = 0

    -- Vérifie si le mot de passe existe déjà dans la table mdpVisiteur
    IF EXISTS (SELECT * FROM gsbjava.mdpVisiteur WHERE MATRICULE = @matricule AND MDP = @mdp)
    BEGIN
        -- Supprime l'enregistrement de la table visiteur pour empêcher l'insertion/mise à jour
        DELETE FROM gsbjava.visiteur WHERE MATRICULE = @matricule
    END
    ELSE
    BEGIN
        -- Insertion de l'enregistrement dans la table visiteur
        INSERT INTO gsbjava.visiteur (MATRICULE, NOM, PRENOM, LOGIN, MDP, ADRESSE, CODEPOSTAL, DATEENTREE, CODEUNIT, NOMUNIT, TELEPHONE, PRIME, DATE_EXP, EXPIRE)
        VALUES (@matricule, @nom, @prenom, @login, @mdp, @adresse, @codepostal, @dateentree, @codeunit, @nomunit, @telephone, @prime, @dateExp, @expire)
    END
END
GO
/****** Object:  StoredProcedure [dbo].[verifierDateExp]    Script Date: 03/04/2023 11:44:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[verifierDateExp]
AS
BEGIN
    DECLARE @matricule VARCHAR(50)
    DECLARE @mdp VARCHAR(50)

    -- Sélectionne les visiteurs dont la date d'expiration est atteinte ou dépassée
    SELECT @matricule = MATRICULE, @mdp = MDP
    FROM visiteur
    WHERE DATE_EXP <= GETDATE() AND EXPIRE = 0

    -- Met à jour le champ 'EXPIRE' pour les visiteurs sélectionnés
    UPDATE visiteur
    SET EXPIRE = 1
    WHERE DATE_EXP <= GETDATE() AND EXPIRE = 0

    -- Appelle la procédure dbo.ajouterMdpVisiteur pour les visiteurs sélectionnés
    IF (@matricule IS NOT NULL AND @mdp IS NOT NULL)
    BEGIN
        EXEC dbo.ajouterMdpVisiteur @matricule, @mdp
    END
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.localite' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'localite'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.medecin' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'medecin'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.medicament' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'medicament'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.stock' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'stock'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.visite' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'visite'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'gsbjava.visiteur' , @level0type=N'SCHEMA',@level0name=N'gsbjava', @level1type=N'TABLE',@level1name=N'visiteur'
GO
