/* A Bison parser, made by GNU Bison 3.5.1.  */

/* Bison implementation for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2020 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Undocumented macros, especially those whose name start with YY_,
   are private implementation details.  Do not rely on them.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.5.1"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* First part of user prologue.  */
#line 3 "trad.y"
                          // SECCION 1 Declaraciones de C-Yacc
#include <stdio.h>
#include <ctype.h>            // declaraciones para tolower
#include <string.h>           // declaraciones para cadenas
#include <stdlib.h>           // declaraciones para exit ()

#define FF fflush(stdout);    // para forzar la impresion inmediata
char temp [2048] ;
char nombre_fun[48] ;
char *genera_cadena (char *nombre);


#line 83 "trad.tab.c"

# ifndef YY_CAST
#  ifdef __cplusplus
#   define YY_CAST(Type, Val) static_cast<Type> (Val)
#   define YY_REINTERPRET_CAST(Type, Val) reinterpret_cast<Type> (Val)
#  else
#   define YY_CAST(Type, Val) ((Type) (Val))
#   define YY_REINTERPRET_CAST(Type, Val) ((Type) (Val))
#  endif
# endif
# ifndef YY_NULLPTR
#  if defined __cplusplus
#   if 201103L <= __cplusplus
#    define YY_NULLPTR nullptr
#   else
#    define YY_NULLPTR 0
#   endif
#  else
#   define YY_NULLPTR ((void*)0)
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 0
#endif


/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    NUMERO = 258,
    IDENTIF = 259,
    INTEGER = 260,
    STRING = 261,
    PUTS = 262,
    LEQ = 263,
    GEQ = 264,
    EQ = 265,
    NEQ = 266,
    AND = 267,
    OR = 268,
    IF = 269,
    ELSE = 270,
    PRINT = 271,
    MAIN = 272,
    WHILE = 273,
    FOR = 274,
    RETURN = 275,
    POW = 276,
    SIGNO_UNARIO = 277
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
union YYSTYPE
{
#line 16 "trad.y"
                      // El tipo de la pila tiene caracter dual
      int valor ;             // - valor numerico de un NUMERO
      char *cadena ;          // - para pasar los nombres de IDENTIFES

#line 160 "trad.tab.c"

};
typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);





#ifdef short
# undef short
#endif

/* On compilers that do not define __PTRDIFF_MAX__ etc., make sure
   <limits.h> and (if available) <stdint.h> are included
   so that the code can choose integer types of a good width.  */

#ifndef __PTRDIFF_MAX__
# include <limits.h> /* INFRINGES ON USER NAME SPACE */
# if defined __STDC_VERSION__ && 199901 <= __STDC_VERSION__
#  include <stdint.h> /* INFRINGES ON USER NAME SPACE */
#  define YY_STDINT_H
# endif
#endif

/* Narrow types that promote to a signed type and that can represent a
   signed or unsigned integer of at least N bits.  In tables they can
   save space and decrease cache pressure.  Promoting to a signed type
   helps avoid bugs in integer arithmetic.  */

#ifdef __INT_LEAST8_MAX__
typedef __INT_LEAST8_TYPE__ yytype_int8;
#elif defined YY_STDINT_H
typedef int_least8_t yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef __INT_LEAST16_MAX__
typedef __INT_LEAST16_TYPE__ yytype_int16;
#elif defined YY_STDINT_H
typedef int_least16_t yytype_int16;
#else
typedef short yytype_int16;
#endif

#if defined __UINT_LEAST8_MAX__ && __UINT_LEAST8_MAX__ <= __INT_MAX__
typedef __UINT_LEAST8_TYPE__ yytype_uint8;
#elif (!defined __UINT_LEAST8_MAX__ && defined YY_STDINT_H \
       && UINT_LEAST8_MAX <= INT_MAX)
typedef uint_least8_t yytype_uint8;
#elif !defined __UINT_LEAST8_MAX__ && UCHAR_MAX <= INT_MAX
typedef unsigned char yytype_uint8;
#else
typedef short yytype_uint8;
#endif

#if defined __UINT_LEAST16_MAX__ && __UINT_LEAST16_MAX__ <= __INT_MAX__
typedef __UINT_LEAST16_TYPE__ yytype_uint16;
#elif (!defined __UINT_LEAST16_MAX__ && defined YY_STDINT_H \
       && UINT_LEAST16_MAX <= INT_MAX)
typedef uint_least16_t yytype_uint16;
#elif !defined __UINT_LEAST16_MAX__ && USHRT_MAX <= INT_MAX
typedef unsigned short yytype_uint16;
#else
typedef int yytype_uint16;
#endif

#ifndef YYPTRDIFF_T
# if defined __PTRDIFF_TYPE__ && defined __PTRDIFF_MAX__
#  define YYPTRDIFF_T __PTRDIFF_TYPE__
#  define YYPTRDIFF_MAXIMUM __PTRDIFF_MAX__
# elif defined PTRDIFF_MAX
#  ifndef ptrdiff_t
#   include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  endif
#  define YYPTRDIFF_T ptrdiff_t
#  define YYPTRDIFF_MAXIMUM PTRDIFF_MAX
# else
#  define YYPTRDIFF_T long
#  define YYPTRDIFF_MAXIMUM LONG_MAX
# endif
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif defined __STDC_VERSION__ && 199901 <= __STDC_VERSION__
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned
# endif
#endif

#define YYSIZE_MAXIMUM                                  \
  YY_CAST (YYPTRDIFF_T,                                 \
           (YYPTRDIFF_MAXIMUM < YY_CAST (YYSIZE_T, -1)  \
            ? YYPTRDIFF_MAXIMUM                         \
            : YY_CAST (YYSIZE_T, -1)))

#define YYSIZEOF(X) YY_CAST (YYPTRDIFF_T, sizeof (X))

/* Stored state numbers (used for stacks). */
typedef yytype_uint8 yy_state_t;

/* State numbers in computations.  */
typedef int yy_state_fast_t;

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# if defined __GNUC__ && 2 < __GNUC__ + (96 <= __GNUC_MINOR__)
#  define YY_ATTRIBUTE_PURE __attribute__ ((__pure__))
# else
#  define YY_ATTRIBUTE_PURE
# endif
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# if defined __GNUC__ && 2 < __GNUC__ + (7 <= __GNUC_MINOR__)
#  define YY_ATTRIBUTE_UNUSED __attribute__ ((__unused__))
# else
#  define YY_ATTRIBUTE_UNUSED
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && ! defined __ICC && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN                            \
    _Pragma ("GCC diagnostic push")                                     \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")              \
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END      \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif

#if defined __cplusplus && defined __GNUC__ && ! defined __ICC && 6 <= __GNUC__
# define YY_IGNORE_USELESS_CAST_BEGIN                          \
    _Pragma ("GCC diagnostic push")                            \
    _Pragma ("GCC diagnostic ignored \"-Wuseless-cast\"")
# define YY_IGNORE_USELESS_CAST_END            \
    _Pragma ("GCC diagnostic pop")
#endif
#ifndef YY_IGNORE_USELESS_CAST_BEGIN
# define YY_IGNORE_USELESS_CAST_BEGIN
# define YY_IGNORE_USELESS_CAST_END
#endif


#define YY_ASSERT(E) ((void) (0 && (E)))

#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yy_state_t yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (YYSIZEOF (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (YYSIZEOF (yy_state_t) + YYSIZEOF (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYPTRDIFF_T yynewbytes;                                         \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * YYSIZEOF (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / YYSIZEOF (*yyptr);                        \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, YY_CAST (YYSIZE_T, (Count)) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYPTRDIFF_T yyi;                      \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  11
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   392

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  39
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  29
/* YYNRULES -- Number of rules.  */
#define YYNRULES  89
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  240

#define YYUNDEFTOK  2
#define YYMAXUTOK   277


/* YYTRANSLATE(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, with out-of-bounds checking.  */
#define YYTRANSLATE(YYX)                                                \
  (0 <= (YYX) && (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex.  */
static const yytype_int8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,    27,     2,     2,
      35,    36,    28,    25,    34,    26,     2,    29,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    31,
      23,    22,    24,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    32,     2,    33,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    37,     2,    38,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    30
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_int16 yyrline[] =
{
       0,    56,    56,    60,    62,    64,    66,    68,    70,    72,
      75,    77,    79,    82,    84,    87,    87,    93,    95,    98,
     100,   104,   106,   109,   111,   113,   115,   117,   119,   121,
     124,   126,   131,   135,   139,   141,   145,   147,   148,   152,
     154,   156,   158,   160,   164,   166,   168,   171,   173,   175,
     177,   181,   185,   187,   190,   192,   195,   196,   198,   200,
     202,   204,   206,   210,   211,   213,   215,   217,   219,   221,
     225,   226,   227,   231,   233,   235,   237,   239,   241,   243,
     245,   249,   250,   252,   254,   255,   258,   262,   264,   266
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "NUMERO", "IDENTIF", "INTEGER", "STRING",
  "PUTS", "LEQ", "GEQ", "EQ", "NEQ", "AND", "OR", "IF", "ELSE", "PRINT",
  "MAIN", "WHILE", "FOR", "RETURN", "POW", "'='", "'<'", "'>'", "'+'",
  "'-'", "'%'", "'*'", "'/'", "SIGNO_UNARIO", "';'", "'['", "']'", "','",
  "'('", "')'", "'{'", "'}'", "$accept", "axioma", "decl", "resdecl",
  "def", "fun", "$@1", "inipar", "resinipar", "mainfun", "cuerpo",
  "decliter", "iter", "progn", "els", "sent", "setq", "ressetq", "impr",
  "callfun", "par", "respar", "expresion", "expresionp", "expresioncond",
  "cond", "termino", "vec", "operando", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_int16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,    61,    60,    62,    43,    45,    37,    42,    47,
     277,    59,    91,    93,    44,    40,    41,   123,   125
};
# endif

#define YYPACT_NINF (-162)

#define yypact_value_is_default(Yyn) \
  ((Yyn) == YYPACT_NINF)

#define YYTABLE_NINF (-70)

#define yytable_value_is_error(Yyn) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
      28,    72,     5,    14,    20,    76,    64,   107,   103,    66,
     -16,  -162,    80,  -162,  -162,  -162,    76,   122,   111,  -162,
      -1,   110,    46,    46,   118,  -162,   343,  -162,  -162,  -162,
     147,   151,   156,   160,   140,   136,  -162,   142,    28,   103,
     103,  -162,  -162,   143,   249,   152,   158,   103,   103,   103,
     103,   103,  -162,   170,   162,   153,   159,   -12,    28,   163,
      28,  -162,   166,   303,   313,   103,   103,   103,   103,   103,
     103,  -162,    25,    25,   139,  -162,  -162,   179,   167,   184,
     185,   187,  -162,  -162,    98,  -162,  -162,   103,  -162,   103,
     323,   194,   208,    91,   181,   191,   224,  -162,    98,    28,
      28,   153,    60,   227,   198,   204,   205,   206,   207,   154,
     222,    98,  -162,   214,   242,   303,   157,   103,   261,   228,
    -162,  -162,  -162,   154,    55,   240,   154,   264,   154,   127,
     193,   279,   272,  -162,  -162,  -162,    98,   103,  -162,  -162,
     291,   179,  -162,   278,   103,   103,   263,   241,   235,   302,
     256,   259,   258,   275,   294,   268,   249,   285,   154,   154,
     154,   154,   154,   154,   154,   154,    98,  -162,   361,   286,
    -162,  -162,   333,   352,    74,  -162,   269,   287,    53,   296,
     103,   301,   154,  -162,  -162,  -162,    67,    67,    16,   138,
    -162,  -162,  -162,  -162,   304,   305,   154,  -162,  -162,    98,
     300,   307,   239,    98,   279,   103,   314,  -162,  -162,   245,
    -162,   306,    53,   315,    53,   316,   279,   349,  -162,   340,
      98,  -162,  -162,  -162,    98,   334,   327,   328,  -162,  -162,
     103,   329,    98,   279,    98,   326,   335,  -162,    98,  -162
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_int8 yydefact[] =
{
       9,    15,     0,     0,    22,    14,     0,     0,     0,     0,
      12,     1,     0,     2,    15,     8,    14,     0,     0,    88,
      87,     0,     0,     0,     0,    85,     0,    56,    84,    81,
      18,     0,     0,     0,     0,     0,    13,     0,     9,    53,
       0,    82,    83,     0,     0,     0,    56,     0,     0,     0,
       0,     0,    86,     0,     0,    12,     0,    12,     9,     0,
       9,     6,     0,    55,     0,     0,     0,     0,     0,     0,
       0,    89,    57,    58,    61,    59,    60,    20,     0,     0,
       0,     0,    11,     3,    29,     7,    51,     0,    52,     0,
       0,    57,    58,    61,    59,    60,     0,    17,    29,     9,
       9,    12,     0,     0,     0,     0,     0,     0,     0,     0,
       0,    29,    37,     0,     0,    55,     0,     0,     0,     0,
       4,     5,    10,     0,    46,     0,     0,     0,     0,     0,
       0,    70,     0,    71,    21,    23,    29,     0,    54,    62,
       0,    20,    16,     0,     0,     0,     0,     0,     0,     0,
      71,     0,    71,     0,     0,     0,    70,    71,     0,     0,
       0,     0,     0,     0,     0,     0,    29,    27,     0,    62,
      19,    41,    46,     0,    46,    39,     0,     0,     0,     0,
       0,     0,     0,    72,    74,    73,    79,    80,    77,    78,
      76,    75,    28,    43,     0,     0,     0,    45,    38,    29,
      48,     0,    47,    29,    31,     0,    71,    40,    42,    46,
      33,     0,     0,     0,     0,     0,    30,     0,    44,    35,
      29,    50,    36,    49,    29,     0,     0,     0,    25,    24,
       0,     0,    29,    32,    29,     0,     0,    34,    29,    26
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
    -162,  -162,   -30,   -50,   358,     7,  -162,  -162,   234,  -162,
     -43,  -162,  -162,   150,  -162,  -162,  -162,  -161,   -77,   -69,
    -162,   276,    -4,  -162,    47,  -109,   -21,     0,  -162
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int16 yydefgoto[] =
{
      -1,     3,     4,    34,    15,     5,     9,    54,    97,    13,
     210,   155,   226,   211,   220,   111,   112,   147,   201,    25,
      62,    88,   131,    45,   149,   133,    27,    28,    29
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int16 yytable[] =
{
       6,    41,    42,    46,    26,    79,    31,    82,    61,    10,
      81,   194,    16,   197,    11,   113,    32,   150,    33,   152,
      44,   157,    33,    16,   158,   159,   160,   161,    83,   113,
      85,     8,     1,     2,    39,    63,    64,    12,     6,   164,
     165,   110,   113,    72,    73,    74,    75,    76,   218,    19,
      20,   122,    49,    50,    51,   119,    19,    20,     6,   200,
       6,    90,    91,    92,    93,    94,    95,   113,   135,   120,
     121,    22,    23,   206,    21,   158,   159,   144,    22,    23,
      14,    24,   123,   115,   114,   116,    17,   145,   130,   146,
     164,   165,     8,   167,     7,    39,   196,   113,   114,     6,
       6,    30,   102,   103,     8,   104,    19,    20,   146,    46,
      18,   114,   105,   140,   106,    35,   107,   108,   109,    50,
      51,    19,    20,   192,    21,    37,   156,   -68,    22,    23,
     113,   153,   154,   168,   113,   221,   114,   223,    24,    43,
     172,   173,    38,    22,    23,    40,   158,   159,   160,   161,
     162,   113,    53,    24,    55,   113,   132,    19,    20,    56,
     215,   164,   165,   113,    57,   113,   114,    50,    51,   113,
     143,    58,    59,    60,    77,    21,   204,   228,    65,    22,
      23,   229,    47,    48,    49,    50,    51,    33,    71,   130,
     101,   236,    80,   139,   -63,   239,    19,    20,    78,   114,
      84,   216,    86,   114,    98,   184,   185,   186,   187,   188,
     189,   190,   191,    96,    43,    99,   100,   -66,    22,    23,
     114,    49,    50,    51,   114,   202,   233,   -67,   130,   118,
     -64,   124,   114,   125,   114,    49,    50,    51,   114,   126,
     127,   128,   129,   209,   -65,   136,   148,   158,   159,   160,
     161,   162,   163,   158,   159,   160,   161,   162,   163,   202,
     134,   202,   164,   165,   137,   141,   142,   174,   164,   165,
     151,   176,   175,   214,    66,    67,    68,    69,    70,   146,
     158,   159,   160,   161,   162,   163,   158,   159,   160,   161,
     162,   163,   177,   178,   179,   164,   165,   180,   181,   182,
     198,   164,   165,   166,    47,    48,    49,    50,    51,   171,
     158,   159,   160,   161,   162,   163,    47,    48,    49,    50,
      51,   183,   -69,   205,   199,   164,   165,   169,    47,    48,
      49,    50,    51,   203,   212,   207,   208,    87,    47,    48,
      49,    50,    51,   213,   219,   217,   222,    89,    47,    48,
      49,    50,    51,   225,   224,   227,   230,   117,    47,    48,
      49,    50,    51,   231,   237,   232,   234,   146,    47,    48,
      49,    50,    51,   238,    36,   170,    52,    47,    48,    49,
      50,    51,   235,     0,     0,   195,    47,    48,    49,    50,
      51,   138,   193
};

static const yytype_int16 yycheck[] =
{
       0,    22,    23,    24,     8,    55,    22,    57,    38,     4,
      22,   172,     5,   174,     0,    84,    32,   126,    34,   128,
      24,   130,    34,    16,     8,     9,    10,    11,    58,    98,
      60,    32,     4,     5,    35,    39,    40,    17,    38,    23,
      24,    84,   111,    47,    48,    49,    50,    51,   209,     3,
       4,   101,    27,    28,    29,    98,     3,     4,    58,     6,
      60,    65,    66,    67,    68,    69,    70,   136,   111,    99,
     100,    25,    26,   182,    21,     8,     9,    22,    25,    26,
       4,    35,    22,    87,    84,    89,    22,    32,    35,    34,
      23,    24,    32,   136,    22,    35,    22,   166,    98,    99,
     100,    35,     4,     5,    32,     7,     3,     4,    34,   130,
       3,   111,    14,   117,    16,    35,    18,    19,    20,    28,
      29,     3,     4,   166,    21,     3,   130,    36,    25,    26,
     199,     4,     5,   137,   203,   212,   136,   214,    35,    21,
     144,   145,    31,    25,    26,    35,     8,     9,    10,    11,
      12,   220,     5,    35,     3,   224,   109,     3,     4,     3,
     203,    23,    24,   232,     4,   234,   166,    28,    29,   238,
     123,    31,    36,    31,     4,    21,   180,   220,    35,    25,
      26,   224,    25,    26,    27,    28,    29,    34,    36,    35,
       3,   234,    33,    36,    36,   238,     3,     4,    36,   199,
      37,   205,    36,   203,    37,   158,   159,   160,   161,   162,
     163,   164,   165,    34,    21,    31,    31,    36,    25,    26,
     220,    27,    28,    29,   224,   178,   230,    36,    35,     5,
      36,     4,   232,    35,   234,    27,    28,    29,   238,    35,
      35,    35,    35,   196,    36,    31,     6,     8,     9,    10,
      11,    12,    13,     8,     9,    10,    11,    12,    13,   212,
      38,   214,    23,    24,    22,     4,    38,     4,    23,    24,
       6,    36,    31,    34,    25,    26,    27,    28,    29,    34,
       8,     9,    10,    11,    12,    13,     8,     9,    10,    11,
      12,    13,    36,    34,    36,    23,    24,    22,     4,    31,
      31,    23,    24,    31,    25,    26,    27,    28,    29,    31,
       8,     9,    10,    11,    12,    13,    25,    26,    27,    28,
      29,    36,    36,    22,    37,    23,    24,    36,    25,    26,
      27,    28,    29,    37,    34,    31,    31,    34,    25,    26,
      27,    28,    29,    36,    38,    31,    31,    34,    25,    26,
      27,    28,    29,     4,    38,    15,    22,    34,    25,    26,
      27,    28,    29,    36,    38,    37,    37,    34,    25,    26,
      27,    28,    29,    38,    16,   141,    33,    25,    26,    27,
      28,    29,   232,    -1,    -1,    33,    25,    26,    27,    28,
      29,   115,    31
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_int8 yystos[] =
{
       0,     4,     5,    40,    41,    44,    66,    22,    32,    45,
       4,     0,    17,    48,     4,    43,    44,    22,     3,     3,
       4,    21,    25,    26,    35,    58,    61,    65,    66,    67,
      35,    22,    32,    34,    42,    35,    43,     3,    31,    35,
      35,    65,    65,    21,    61,    62,    65,    25,    26,    27,
      28,    29,    33,     5,    46,     3,     3,     4,    31,    36,
      31,    41,    59,    61,    61,    35,    25,    26,    27,    28,
      29,    36,    61,    61,    61,    61,    61,     4,    36,    42,
      33,    22,    42,    41,    37,    41,    36,    34,    60,    34,
      61,    61,    61,    61,    61,    61,    34,    47,    37,    31,
      31,     3,     4,     5,     7,    14,    16,    18,    19,    20,
      49,    54,    55,    58,    66,    61,    61,    34,     5,    49,
      41,    41,    42,    22,     4,    35,    35,    35,    35,    35,
      35,    61,    63,    64,    38,    49,    31,    22,    60,    36,
      61,     4,    38,    63,    22,    32,    34,    56,     6,    63,
      64,     6,    64,     4,     5,    50,    61,    64,     8,     9,
      10,    11,    12,    13,    23,    24,    31,    49,    61,    36,
      47,    31,    61,    61,     4,    31,    36,    36,    34,    36,
      22,     4,    31,    36,    63,    63,    63,    63,    63,    63,
      63,    63,    49,    31,    56,    33,    22,    56,    31,    37,
       6,    57,    63,    37,    61,    22,    64,    31,    31,    63,
      49,    52,    34,    36,    34,    49,    61,    31,    56,    38,
      53,    57,    31,    57,    38,     4,    51,    15,    49,    49,
      22,    36,    37,    61,    37,    52,    49,    38,    38,    49
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_int8 yyr1[] =
{
       0,    39,    40,    41,    41,    41,    41,    41,    41,    41,
      42,    42,    42,    43,    43,    45,    44,    46,    46,    47,
      47,    48,    48,    49,    49,    49,    49,    49,    49,    49,
      50,    50,    51,    52,    53,    53,    54,    54,    54,    55,
      55,    55,    55,    55,    56,    56,    56,    57,    57,    57,
      57,    58,    59,    59,    60,    60,    61,    61,    61,    61,
      61,    61,    61,    62,    62,    62,    62,    62,    62,    62,
      63,    63,    63,    64,    64,    64,    64,    64,    64,    64,
      64,    65,    65,    65,    65,    65,    66,    67,    67,    67
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_int8 yyr2[] =
{
       0,     2,     2,     5,     7,     7,     5,     5,     2,     0,
       5,     3,     0,     2,     0,     0,     8,     3,     0,     4,
       0,     6,     0,     2,     8,     8,    12,     3,     4,     0,
       4,     3,     3,     1,     5,     1,     7,     1,     5,     4,
       6,     4,     6,     4,     5,     3,     0,     1,     1,     3,
       3,     4,     2,     0,     3,     0,     1,     3,     3,     3,
       3,     3,     6,     1,     3,     3,     3,     3,     3,     6,
       1,     1,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     1,     2,     2,     1,     1,     4,     1,     1,     3
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                    \
  do                                                              \
    if (yychar == YYEMPTY)                                        \
      {                                                           \
        yychar = (Token);                                         \
        yylval = (Value);                                         \
        YYPOPSTACK (yylen);                                       \
        yystate = *yyssp;                                         \
        goto yybackup;                                            \
      }                                                           \
    else                                                          \
      {                                                           \
        yyerror (YY_("syntax error: cannot back up")); \
        YYERROR;                                                  \
      }                                                           \
  while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*-----------------------------------.
| Print this symbol's value on YYO.  |
`-----------------------------------*/

static void
yy_symbol_value_print (FILE *yyo, int yytype, YYSTYPE const * const yyvaluep)
{
  FILE *yyoutput = yyo;
  YYUSE (yyoutput);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyo, yytoknum[yytype], *yyvaluep);
# endif
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}


/*---------------------------.
| Print this symbol on YYO.  |
`---------------------------*/

static void
yy_symbol_print (FILE *yyo, int yytype, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyo, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyo, yytype, yyvaluep);
  YYFPRINTF (yyo, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yy_state_t *yybottom, yy_state_t *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yy_state_t *yyssp, YYSTYPE *yyvsp, int yyrule)
{
  int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %d):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[+yyssp[yyi + 1 - yynrhs]],
                       &yyvsp[(yyi + 1) - (yynrhs)]
                                              );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen(S) (YY_CAST (YYPTRDIFF_T, strlen (S)))
#  else
/* Return the length of YYSTR.  */
static YYPTRDIFF_T
yystrlen (const char *yystr)
{
  YYPTRDIFF_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYPTRDIFF_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYPTRDIFF_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            else
              goto append;

          append:
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (yyres)
    return yystpcpy (yyres, yystr) - yyres;
  else
    return yystrlen (yystr);
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYPTRDIFF_T *yymsg_alloc, char **yymsg,
                yy_state_t *yyssp, int yytoken)
{
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat: reported tokens (one for the "unexpected",
     one per "expected"). */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Actual size of YYARG. */
  int yycount = 0;
  /* Cumulated lengths of YYARG.  */
  YYPTRDIFF_T yysize = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[+*yyssp];
      YYPTRDIFF_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
      yysize = yysize0;
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYPTRDIFF_T yysize1
                    = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM)
                    yysize = yysize1;
                  else
                    return 2;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
    default: /* Avoid compiler warnings. */
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    /* Don't count the "%s"s in the final size, but reserve room for
       the terminator.  */
    YYPTRDIFF_T yysize1 = yysize + (yystrlen (yyformat) - 2 * yycount) + 1;
    if (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM)
      yysize = yysize1;
    else
      return 2;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          ++yyp;
          ++yyformat;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
{
  YYUSE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/* The lookahead symbol.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    yy_state_fast_t yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yy_state_t yyssa[YYINITDEPTH];
    yy_state_t *yyss;
    yy_state_t *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYPTRDIFF_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYPTRDIFF_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;


/*------------------------------------------------------------.
| yynewstate -- push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;


/*--------------------------------------------------------------------.
| yysetstate -- set current state (the top of the stack) to yystate.  |
`--------------------------------------------------------------------*/
yysetstate:
  YYDPRINTF ((stderr, "Entering state %d\n", yystate));
  YY_ASSERT (0 <= yystate && yystate < YYNSTATES);
  YY_IGNORE_USELESS_CAST_BEGIN
  *yyssp = YY_CAST (yy_state_t, yystate);
  YY_IGNORE_USELESS_CAST_END

  if (yyss + yystacksize - 1 <= yyssp)
#if !defined yyoverflow && !defined YYSTACK_RELOCATE
    goto yyexhaustedlab;
#else
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYPTRDIFF_T yysize = yyssp - yyss + 1;

# if defined yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        yy_state_t *yyss1 = yyss;
        YYSTYPE *yyvs1 = yyvs;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * YYSIZEOF (*yyssp),
                    &yyvs1, yysize * YYSIZEOF (*yyvsp),
                    &yystacksize);
        yyss = yyss1;
        yyvs = yyvs1;
      }
# else /* defined YYSTACK_RELOCATE */
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yy_state_t *yyss1 = yyss;
        union yyalloc *yyptr =
          YY_CAST (union yyalloc *,
                   YYSTACK_ALLOC (YY_CAST (YYSIZE_T, YYSTACK_BYTES (yystacksize))));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
# undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YY_IGNORE_USELESS_CAST_BEGIN
      YYDPRINTF ((stderr, "Stack size increased to %ld\n",
                  YY_CAST (long, yystacksize)));
      YY_IGNORE_USELESS_CAST_END

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }
#endif /* !defined yyoverflow && !defined YYSTACK_RELOCATE */

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;


/*-----------.
| yybackup.  |
`-----------*/
yybackup:
  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex ();
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);
  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  /* Discard the shifted token.  */
  yychar = YYEMPTY;
  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
  case 2:
#line 56 "trad.y"
                                        { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                    printf("%s", genera_cadena(temp)); }
#line 1510 "trad.tab.c"
    break;

  case 3:
#line 60 "trad.y"
                                                                  { sprintf(temp, "(setq %s 0)\n%s%s", (yyvsp[-3].cadena), (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1517 "trad.tab.c"
    break;

  case 4:
#line 62 "trad.y"
                                                                      { sprintf(temp, "(setq %s %d)\n%s%s", (yyvsp[-5].cadena), (yyvsp[-3].valor), (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1524 "trad.tab.c"
    break;

  case 5:
#line 64 "trad.y"
                                                                    { sprintf(temp, "(setq %s (make-array %d))\n%s", (yyvsp[-5].cadena), (yyvsp[-3].valor), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1531 "trad.tab.c"
    break;

  case 6:
#line 66 "trad.y"
                                                                        { sprintf(temp, "(setq %s %d)\n%s", (yyvsp[-4].cadena), (yyvsp[-2].valor), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1538 "trad.tab.c"
    break;

  case 7:
#line 68 "trad.y"
                                                                    { sprintf(temp, "(setf %s %d)\n%s", (yyvsp[-4].cadena), (yyvsp[-2].valor), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1545 "trad.tab.c"
    break;

  case 8:
#line 70 "trad.y"
                                                                  { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1552 "trad.tab.c"
    break;

  case 9:
#line 72 "trad.y"
                                                                      { (yyval.cadena) = genera_cadena(""); }
#line 1558 "trad.tab.c"
    break;

  case 10:
#line 75 "trad.y"
                                                      { sprintf(temp, "(setq %s %d)\n%s", (yyvsp[-3].cadena), (yyvsp[-1].valor), (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1565 "trad.tab.c"
    break;

  case 11:
#line 77 "trad.y"
                                                    { sprintf(temp, "(setq %s 0)\n%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1572 "trad.tab.c"
    break;

  case 12:
#line 79 "trad.y"
                                                        { (yyval.cadena) = genera_cadena(""); }
#line 1578 "trad.tab.c"
    break;

  case 13:
#line 82 "trad.y"
                                    { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                    (yyval.cadena) = genera_cadena(temp); }
#line 1585 "trad.tab.c"
    break;

  case 14:
#line 84 "trad.y"
                                      { (yyval.cadena) = genera_cadena(""); }
#line 1591 "trad.tab.c"
    break;

  case 15:
#line 87 "trad.y"
                                                    { sprintf(nombre_fun, "%s", (yyvsp[0].cadena)); }
#line 1597 "trad.tab.c"
    break;

  case 16:
#line 88 "trad.y"
                                                      { sprintf(temp, "(defun %s (%s)\n%s)\n", nombre_fun, (yyvsp[-4].cadena), (yyvsp[-1].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1604 "trad.tab.c"
    break;

  case 17:
#line 93 "trad.y"
                                                      { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1611 "trad.tab.c"
    break;

  case 18:
#line 95 "trad.y"
                                                { (yyval.cadena) = genera_cadena(""); }
#line 1617 "trad.tab.c"
    break;

  case 19:
#line 98 "trad.y"
                                                      { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1624 "trad.tab.c"
    break;

  case 20:
#line 100 "trad.y"
                                                  { (yyval.cadena) = genera_cadena(""); }
#line 1630 "trad.tab.c"
    break;

  case 21:
#line 104 "trad.y"
                                                      { sprintf(temp, "(defun %s ()\n%s)\n", (yyvsp[-5].cadena), (yyvsp[-1].cadena));
                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1637 "trad.tab.c"
    break;

  case 22:
#line 106 "trad.y"
                                                  { (yyval.cadena) = genera_cadena(""); }
#line 1643 "trad.tab.c"
    break;

  case 23:
#line 109 "trad.y"
                                                                                  { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1650 "trad.tab.c"
    break;

  case 24:
#line 111 "trad.y"
                                                                                  { sprintf(temp, "\t(loop %s %s do\n%s\t)\n%s", (yyvsp[-7].cadena), (yyvsp[-5].cadena), (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1657 "trad.tab.c"
    break;

  case 25:
#line 113 "trad.y"
                                                                                  { sprintf(temp, "\t(if %s\n\t%s%s%s", (yyvsp[-5].cadena), (yyvsp[-2].cadena), (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1664 "trad.tab.c"
    break;

  case 26:
#line 115 "trad.y"
                                                                                      { sprintf(temp, "%s\t(loop while %s do\n%s%s\t)\n%s", (yyvsp[-9].cadena), (yyvsp[-7].cadena), (yyvsp[-2].cadena), (yyvsp[-5].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1671 "trad.tab.c"
    break;

  case 27:
#line 117 "trad.y"
                                                                                  { sprintf(temp, "\t%s\n%s", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1678 "trad.tab.c"
    break;

  case 28:
#line 119 "trad.y"
                                                                                  { sprintf(temp, "\t(return-from %s %s)\n%s", nombre_fun,(yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                                                    (yyval.cadena) = genera_cadena(temp); }
#line 1685 "trad.tab.c"
    break;

  case 29:
#line 121 "trad.y"
                                                                                      { (yyval.cadena) = genera_cadena(""); }
#line 1691 "trad.tab.c"
    break;

  case 30:
#line 124 "trad.y"
                                                      { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1698 "trad.tab.c"
    break;

  case 31:
#line 126 "trad.y"
                                                      { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1705 "trad.tab.c"
    break;

  case 32:
#line 131 "trad.y"
                                              { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1712 "trad.tab.c"
    break;

  case 33:
#line 135 "trad.y"
                                     { sprintf(temp, "(progn\n%s\t)\n", (yyvsp[0].cadena));
                                       (yyval.cadena) = genera_cadena(temp); }
#line 1719 "trad.tab.c"
    break;

  case 34:
#line 139 "trad.y"
                                              { sprintf(temp, "\t%s\t)\n", (yyvsp[-1].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1726 "trad.tab.c"
    break;

  case 35:
#line 141 "trad.y"
                                            { sprintf(temp, "\t)\n");
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1733 "trad.tab.c"
    break;

  case 36:
#line 145 "trad.y"
                                                              { if(strcmp(temp, " ") != 0) sprintf(temp, "\t%s\n", genera_cadena(temp));
                                                          (yyval.cadena) = genera_cadena(temp); }
#line 1740 "trad.tab.c"
    break;

  case 37:
#line 147 "trad.y"
                                                        { (yyval.cadena) = genera_cadena(temp); }
#line 1746 "trad.tab.c"
    break;

  case 38:
#line 148 "trad.y"
                                                        { sprintf(temp, "\t(print \"%s\")\n", (yyvsp[-2].cadena));
                                                          (yyval.cadena) = genera_cadena(temp); }
#line 1753 "trad.tab.c"
    break;

  case 39:
#line 152 "trad.y"
                                                                { sprintf(temp, "\t(setq %s 0)\n%s", (yyvsp[-2].cadena), (yyvsp[-1].cadena));
                                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1760 "trad.tab.c"
    break;

  case 40:
#line 154 "trad.y"
                                                                      { sprintf(temp, "\t(setq %s %s)\n%s", (yyvsp[-4].cadena), (yyvsp[-2].cadena), (yyvsp[-1].cadena));
                                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1767 "trad.tab.c"
    break;

  case 41:
#line 156 "trad.y"
                                                                    { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1774 "trad.tab.c"
    break;

  case 42:
#line 158 "trad.y"
                                                                  { sprintf(temp, "\t(setq %s (make-array %s))\n", (yyvsp[-4].cadena), (yyvsp[-2].cadena));
                                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1781 "trad.tab.c"
    break;

  case 43:
#line 160 "trad.y"
                                                                  { sprintf(temp, "\t(setf %s %s)\n", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1788 "trad.tab.c"
    break;

  case 44:
#line 164 "trad.y"
                                                              { sprintf(temp, "\t(setq %s %s)\n%s", (yyvsp[-3].cadena), (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                              (yyval.cadena) = genera_cadena(temp); }
#line 1795 "trad.tab.c"
    break;

  case 45:
#line 166 "trad.y"
                                                            { sprintf(temp, "\t(setq %s 0)\n%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                              (yyval.cadena) = genera_cadena(temp); }
#line 1802 "trad.tab.c"
    break;

  case 46:
#line 168 "trad.y"
                                                                { (yyval.cadena) = genera_cadena(""); }
#line 1808 "trad.tab.c"
    break;

  case 47:
#line 171 "trad.y"
                                                { sprintf(temp, "(print %s)", (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1815 "trad.tab.c"
    break;

  case 48:
#line 173 "trad.y"
                                              { sprintf(temp, " ");
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1822 "trad.tab.c"
    break;

  case 49:
#line 175 "trad.y"
                                              { sprintf(temp, "(print %s) %s", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1829 "trad.tab.c"
    break;

  case 50:
#line 177 "trad.y"
                                            { sprintf(temp, "%s", (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1836 "trad.tab.c"
    break;

  case 51:
#line 181 "trad.y"
                                              { sprintf(temp, "(%s%s)", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                            (yyval.cadena) = genera_cadena(temp); }
#line 1843 "trad.tab.c"
    break;

  case 52:
#line 185 "trad.y"
                                      { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                        (yyval.cadena) = genera_cadena(temp); }
#line 1850 "trad.tab.c"
    break;

  case 53:
#line 187 "trad.y"
                                          { (yyval.cadena) = genera_cadena(""); }
#line 1856 "trad.tab.c"
    break;

  case 54:
#line 190 "trad.y"
                                              { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                            (yyval.cadena) = genera_cadena(temp); }
#line 1863 "trad.tab.c"
    break;

  case 55:
#line 192 "trad.y"
                                              { (yyval.cadena) = genera_cadena(""); }
#line 1869 "trad.tab.c"
    break;

  case 56:
#line 195 "trad.y"
                                                                                    { (yyval.cadena) = (yyvsp[0].cadena); }
#line 1875 "trad.tab.c"
    break;

  case 57:
#line 196 "trad.y"
                                                          { sprintf(temp, "(+ %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1882 "trad.tab.c"
    break;

  case 58:
#line 198 "trad.y"
                                                          { sprintf(temp, "(- %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1889 "trad.tab.c"
    break;

  case 59:
#line 200 "trad.y"
                                                          { sprintf(temp, "(* %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1896 "trad.tab.c"
    break;

  case 60:
#line 202 "trad.y"
                                                                    { sprintf(temp, "(/ %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1903 "trad.tab.c"
    break;

  case 61:
#line 204 "trad.y"
                                                                    { sprintf(temp, "(mod %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1910 "trad.tab.c"
    break;

  case 62:
#line 206 "trad.y"
                                                              { sprintf(temp, "(expt %s %s)", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1917 "trad.tab.c"
    break;

  case 63:
#line 210 "trad.y"
                                                                                    { (yyval.cadena) = (yyvsp[0].cadena); }
#line 1923 "trad.tab.c"
    break;

  case 64:
#line 211 "trad.y"
                                                          { sprintf(temp, "((+ %s %s))", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1930 "trad.tab.c"
    break;

  case 65:
#line 213 "trad.y"
                                                          { sprintf(temp, "((- %s %s))", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1937 "trad.tab.c"
    break;

  case 66:
#line 215 "trad.y"
                                                          { sprintf(temp, "((* %s %s))", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1944 "trad.tab.c"
    break;

  case 67:
#line 217 "trad.y"
                                                                    { sprintf(temp, "((/ %s %s))", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1951 "trad.tab.c"
    break;

  case 68:
#line 219 "trad.y"
                                                                    { sprintf(temp, "((mod %s %s))", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1958 "trad.tab.c"
    break;

  case 69:
#line 221 "trad.y"
                                                              { sprintf(temp, "((expt %s %s))", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                            (yyval.cadena) = genera_cadena(temp); }
#line 1965 "trad.tab.c"
    break;

  case 70:
#line 225 "trad.y"
                                      { (yyval.cadena) = genera_cadena(temp); }
#line 1971 "trad.tab.c"
    break;

  case 71:
#line 226 "trad.y"
                                      { (yyval.cadena) = genera_cadena(temp); }
#line 1977 "trad.tab.c"
    break;

  case 72:
#line 227 "trad.y"
                                        { sprintf(temp, "%s", (yyvsp[-1].cadena));
                                        (yyval.cadena) = genera_cadena(temp); }
#line 1984 "trad.tab.c"
    break;

  case 73:
#line 231 "trad.y"
                                                     { sprintf(temp, "(>= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 1991 "trad.tab.c"
    break;

  case 74:
#line 233 "trad.y"
                                                      { sprintf(temp, "(<= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 1998 "trad.tab.c"
    break;

  case 75:
#line 235 "trad.y"
                                                        { sprintf(temp, "(> %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2005 "trad.tab.c"
    break;

  case 76:
#line 237 "trad.y"
                                                      { sprintf(temp, "(< %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2012 "trad.tab.c"
    break;

  case 77:
#line 239 "trad.y"
                                                        { sprintf(temp, "(and %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2019 "trad.tab.c"
    break;

  case 78:
#line 241 "trad.y"
                                                        { sprintf(temp, "(or %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2026 "trad.tab.c"
    break;

  case 79:
#line 243 "trad.y"
                                                        { sprintf(temp, "(= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2033 "trad.tab.c"
    break;

  case 80:
#line 245 "trad.y"
                                                      { sprintf(temp, "(/= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                        (yyval.cadena) = genera_cadena(temp); }
#line 2040 "trad.tab.c"
    break;

  case 81:
#line 249 "trad.y"
                                                                      { (yyval.cadena) = (yyvsp[0].cadena); }
#line 2046 "trad.tab.c"
    break;

  case 82:
#line 250 "trad.y"
                                                      { sprintf(temp, "(+ %s)", (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 2053 "trad.tab.c"
    break;

  case 83:
#line 252 "trad.y"
                                                        { sprintf(temp, "(- %s)", (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 2060 "trad.tab.c"
    break;

  case 84:
#line 254 "trad.y"
                                                    { (yyval.cadena) = (yyvsp[0].cadena); }
#line 2066 "trad.tab.c"
    break;

  case 85:
#line 255 "trad.y"
                                                    { (yyval.cadena) = (yyvsp[0].cadena); }
#line 2072 "trad.tab.c"
    break;

  case 86:
#line 258 "trad.y"
                                                      { sprintf(temp, "(aref %s %s)", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2079 "trad.tab.c"
    break;

  case 87:
#line 262 "trad.y"
                                                { sprintf(temp,"%s", (yyvsp[0].cadena));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2086 "trad.tab.c"
    break;

  case 88:
#line 264 "trad.y"
                                        { sprintf(temp,"%d", (yyvsp[0].valor));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2093 "trad.tab.c"
    break;

  case 89:
#line 266 "trad.y"
                                              { (yyval.cadena) = (yyvsp[-1].cadena); }
#line 2099 "trad.tab.c"
    break;


#line 2103 "trad.tab.c"

      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */
  {
    const int yylhs = yyr1[yyn] - YYNTOKENS;
    const int yyi = yypgoto[yylhs] + *yyssp;
    yystate = (0 <= yyi && yyi <= YYLAST && yycheck[yyi] == *yyssp
               ? yytable[yyi]
               : yydefgoto[yylhs]);
  }

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = YY_CAST (char *, YYSTACK_ALLOC (YY_CAST (YYSIZE_T, yymsg_alloc)));
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:
  /* Pacify compilers when the user code never invokes YYERROR and the
     label yyerrorlab therefore never appears in user code.  */
  if (0)
    YYERROR;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;


/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;


#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif


/*-----------------------------------------------------.
| yyreturn -- parsing is finished, return the result.  |
`-----------------------------------------------------*/
yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[+*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 269 "trad.y"

                            // SECCION 4    Codigo en C
int n_linea = 1 ;

int yyerror (mensaje)
char *mensaje ;
{
    fprintf (stderr, "%s en la linea %d\n", mensaje, n_linea) ;
    printf ("\n") ;	// bye
}

char *mi_malloc (int nbytes)       // reserva n bytes de memoria dinamica
{
    char *p ;
    static long int nb = 0;        // sirven para contabilizar la memoria
    static int nv = 0 ;            // solicitada en total

    p = malloc (nbytes) ;
    if (p == NULL) {
         fprintf (stderr, "No queda memoria para %d bytes mas\n", nbytes) ;
         fprintf (stderr, "Reservados %ld bytes en %d llamadas\n", nb, nv) ;
         exit (0) ;
    }
    nb += (long) nbytes ;
    nv++ ;

    return p ;
}


/***************************************************************************/
/********************** Seccion de Palabras Reservadas *********************/
/***************************************************************************/

typedef struct s_pal_reservadas { // para las palabras reservadas de C
    char *nombre ;
    int token ;
} t_reservada ;

t_reservada pal_reservadas [] = { // define las palabras reservadas y los
    "main",        MAIN,           // y los token asociados
    "int",         INTEGER,
    "while",       WHILE,
    "puts",        PUTS,
    "if",          IF,
    "else",        ELSE,
    "printf",      PRINT,
    ">=",          GEQ,
    "<=",          LEQ,
    "&&",          AND,
    "||",          OR,
    "==",          EQ,
    "!=",          NEQ,
    "for",         FOR,
    "return",      RETURN,
    "pow",         POW,
    NULL,          0               // para marcar el fin de la tabla
} ;

t_reservada *busca_pal_reservada (char *nombre_simbolo)
{                                  // Busca n_s en la tabla de pal. res.
                                   // y devuelve puntero a registro (simbolo)
    int i ;
    t_reservada *sim ;

    i = 0 ;
    sim = pal_reservadas ;
    while (sim [i].nombre != NULL) {
           if (strcmp (sim [i].nombre, nombre_simbolo) == 0) {
                                         // strcmp(a, b) devuelve == 0 si a==b
                 return &(sim [i]) ;
             }
           i++ ;
    }

    return NULL ;
}


/***************************************************************************/
/******************* Seccion del Analizador Lexicografico ******************/
/***************************************************************************/

char *genera_cadena (char *nombre)     // copia el argumento a un
{                                      // string en memoria dinamica
      char *p ;
      int l ;

      l = strlen (nombre)+1 ;
      p = (char *) mi_malloc (l) ;
      strcpy (p, nombre) ;

      return p ;
}


int yylex ()
{
    int i ;
    unsigned char c ;
    unsigned char cc ;
    char ops_expandibles [] = "!<=>|%&+-/*" ;
    char cadena [256] ;
    t_reservada *simbolo ;

    do {
    	c = getchar () ;

		if (c == '#') {	// Ignora las lineas que empiezan por #  (#define, #include)
			do {		//	OJO que puede funcionar mal si una linea contiene #
			 c = getchar () ;
			} while (c != '\n') ;
		}

		if (c == '/') {	// Si la linea contiene un / puede ser inicio de comentario
			cc = getchar () ;
			if (cc != '/') {   // Si el siguiente char es /  es un comentario, pero...
				ungetc (cc, stdin) ;
		 } else {
		     c = getchar () ;	// ...
		     if (c == '@') {	// Si es la secuencia //@  ==> transcribimos la linea
		          do {		// Se trata de codigo inline (Codigo embebido en C)
		              c = getchar () ;
		              putchar (c) ;
		          } while (c != '\n') ;
		     } else {		// ==> comentario, ignorar la linea
		          while (c != '\n') {
		              c = getchar () ;
		          }
		     }
		 }
		}

		if (c == '\n')
		 n_linea++ ;

    } while (c == ' ' || c == '\n' || c == 10 || c == 13 || c == '\t') ;

    if (c == '\"') {
         i = 0 ;
         do {
             c = getchar () ;
             cadena [i++] = c ;
         } while (c != '\"' && i < 255) ;
         if (i == 256) {
              printf ("AVISO: string con mas de 255 caracteres en linea %d\n", n_linea) ;
         }		 	// habria que leer hasta el siguiente " , pero, y si falta?
         cadena [--i] = '\0' ;
         yylval.cadena = genera_cadena (cadena) ;
         return (STRING) ;
    }

    if (c == '.' || (c >= '0' && c <= '9')) {
         ungetc (c, stdin) ;
         scanf ("%d", &yylval.valor) ;
//         printf ("\nDEV: NUMERO %d\n", yylval.valor) ;        // PARA DEPURAR
         return NUMERO ;
    }

    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
         i = 0 ;
         while (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                 (c >= '0' && c <= '9') || c == '_') && i < 255) {
             cadena [i++] = tolower (c) ;
             c = getchar () ;
         }
         cadena [i] = '\0' ;
         ungetc (c, stdin) ;

         yylval.cadena = genera_cadena (cadena) ;
         simbolo = busca_pal_reservada (yylval.cadena) ;
         if (simbolo == NULL) {    // no es palabra reservada -> identificador
//               printf ("\nDEV: IDENTIF %s\n", yylval.cadena) ;    // PARA DEPURAR
               return (IDENTIF) ;
         } else {
//               printf ("\nDEV: OTRO %s\n", yylval.cadena) ;       // PARA DEPURAR
               return (simbolo->token) ;
         }
    }

    if (strchr (ops_expandibles, c) != NULL) { // busca c en ops_expandibles
         cc = getchar () ;
         sprintf (cadena, "%c%c", (char) c, (char) cc) ;
         simbolo = busca_pal_reservada (cadena) ;
         if (simbolo == NULL) {
              ungetc (cc, stdin) ;
              yylval.cadena = NULL ;
              return (c) ;
         } else {
              yylval.cadena = genera_cadena (cadena) ; // aunque no se use
              return (simbolo->token) ;
         }
    }

//    printf ("\nDEV: LITERAL %d #%c#\n", (int) c, c) ;      // PARA DEPURAR
    if (c == EOF || c == 255 || c == 26) {
//         printf ("tEOF ") ;                                // PARA DEPURAR
         return (0) ;
    }

    return c ;
}


int main ()
{
    yyparse () ;
}
