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
#line 3 "trad3.y"
                          // SECCION 1 Declaraciones de C-Yacc
#include <stdio.h>
#include <ctype.h>            // declaraciones para tolower
#include <string.h>           // declaraciones para cadenas
#include <stdlib.h>           // declaraciones para exit ()

#define FF fflush(stdout);    // para forzar la impresion inmediata
char temp [2048] ;
char *genera_cadena (char *nombre);


#line 82 "trad3.tab.c"

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
    SIGNO_UNARIO = 275
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
union YYSTYPE
{
#line 15 "trad3.y"
                      // El tipo de la pila tiene caracter dual
      int valor ;             // - valor numerico de un NUMERO
      char *cadena ;          // - para pasar los nombres de IDENTIFES

#line 157 "trad3.tab.c"

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
#define YYFINAL  5
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   257

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  36
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  61
/* YYNRULES -- Number of rules.  */
#define YYNRULES  108
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  231

#define YYUNDEFTOK  2
#define YYMAXUTOK   275


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
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
      32,    33,    25,    23,    31,    24,     2,    26,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    28,
      21,    20,    22,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    29,     2,    30,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    34,     2,    35,     2,     2,     2,     2,
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
      15,    16,    17,    18,    19,    27
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_int16 yyrline[] =
{
       0,    51,    51,    51,    55,    57,    55,    59,    61,    59,
      66,    66,    72,    75,    75,    78,    78,    81,    84,    85,
      85,    87,    90,    92,    90,    97,    99,   102,   104,   108,
     110,   108,   115,   115,   117,   119,   120,   122,   123,   117,
     126,   128,   129,   130,   131,   126,   133,   135,   137,   138,
     133,   140,   140,   142,   145,   149,   153,   154,   153,   157,
     161,   162,   163,   167,   167,   170,   170,   173,   175,   177,
     181,   181,   184,   184,   187,   190,   192,   194,   196,   198,
     202,   206,   208,   210,   212,   215,   216,   218,   220,   222,
     226,   227,   228,   232,   234,   236,   238,   240,   242,   244,
     246,   250,   251,   253,   255,   258,   262,   264,   266
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "NUMERO", "IDENTIF", "INTEGER", "STRING",
  "PUTS", "LEQ", "GEQ", "EQ", "NEQ", "AND", "OR", "IF", "ELSE", "PRINT",
  "MAIN", "WHILE", "FOR", "'='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'",
  "SIGNO_UNARIO", "';'", "'['", "']'", "','", "'('", "')'", "'{'", "'}'",
  "$accept", "axioma", "$@1", "decl", "$@2", "$@3", "$@4", "$@5", "$@6",
  "resdecl", "$@7", "$@8", "def", "$@9", "fun", "$@10", "$@11", "inipar",
  "resinipar", "mainfun", "$@12", "$@13", "cuerpo", "$@14", "$@15", "$@16",
  "$@17", "$@18", "$@19", "$@20", "$@21", "$@22", "$@23", "$@24", "$@25",
  "$@26", "$@27", "$@28", "$@29", "decliter", "iter", "els", "$@30",
  "$@31", "sent", "setq", "$@32", "$@33", "ressetq", "$@34", "$@35",
  "impr", "callfun", "par", "respar", "expresion", "expresioncond", "cond",
  "termino", "vec", "operando", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_int16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
      61,    60,    62,    43,    45,    42,    47,   275,    59,    91,
      93,    44,    40,    41,   123,   125
};
# endif

#define YYPACT_NINF (-184)

#define yypact_value_is_default(Yyn) \
  ((Yyn) == YYPACT_NINF)

#define YYTABLE_NINF (-42)

#define yytable_value_is_error(Yyn) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
      20,    11,    27,  -184,    19,  -184,    54,    41,    63,    36,
      37,    59,  -184,  -184,  -184,  -184,    38,    89,    66,    90,
      65,    54,    36,    77,   102,  -184,   123,   101,    98,  -184,
     113,  -184,   148,    36,    20,   126,   124,  -184,  -184,    20,
    -184,  -184,  -184,   154,  -184,  -184,   110,    20,  -184,    36,
     162,   110,   120,   166,   143,   144,   147,   158,   161,  -184,
    -184,  -184,   171,   160,  -184,  -184,   126,  -184,    10,    58,
      58,    60,   185,  -184,   195,  -184,   202,   165,   110,  -184,
      58,  -184,   173,  -184,   186,    58,    58,    10,   194,    91,
    -184,  -184,  -184,  -184,    58,   172,   176,   163,    58,    58,
     190,   189,    10,   192,    10,   220,   197,  -184,  -184,   110,
     188,  -184,  -184,  -184,   159,   134,   193,    58,    58,    58,
      58,    10,    10,    10,    10,    10,    10,    10,    10,  -184,
     159,  -184,  -184,    58,  -184,   194,   180,   223,   200,   201,
     198,     6,   199,   210,    10,  -184,  -184,  -184,  -184,    21,
      21,  -184,  -184,  -184,  -184,    43,    43,    99,   152,  -184,
    -184,   163,   190,   205,   214,  -184,  -184,   203,   -21,   204,
     206,  -184,    75,   207,    58,   209,  -184,   213,  -184,    10,
     190,   208,     6,   215,     6,   211,   194,   234,  -184,   134,
    -184,  -184,  -184,  -184,  -184,  -184,   224,   216,   190,   132,
     110,    58,  -184,  -184,    96,  -184,  -184,   194,   212,   217,
     218,  -184,   232,  -184,  -184,   110,   221,   110,   110,  -184,
    -184,  -184,  -184,   219,   132,  -184,  -184,   110,   222,  -184,
    -184
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_int8 yydefact[] =
{
      12,     0,     0,     2,     4,     1,    21,     0,     0,    17,
       0,     0,     3,    19,    18,     7,     0,     0,     0,    26,
       0,    21,    17,     0,    15,     5,     0,     0,     0,    20,
       0,    10,     0,    17,    12,    28,     0,    29,     8,    12,
      13,    16,     6,     0,    25,    22,    53,    12,    11,    17,
       0,    53,     0,     0,     0,     0,     0,     0,     0,    30,
      32,    61,     0,     0,     9,    14,    28,    23,     0,     0,
      82,    63,     0,    40,     0,    34,     0,     0,    53,    51,
       0,    27,     0,   107,   106,     0,     0,     0,    90,     0,
      91,    85,   104,   101,     0,     0,     0,    84,     0,     0,
      74,     0,     0,     0,     0,     0,     0,    31,    33,    53,
       0,    24,   102,   103,    90,     0,    91,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,    67,
       0,   105,    80,     0,    81,    65,     0,     0,     0,     0,
      91,     0,    91,     0,     0,    52,    69,   108,    92,    86,
      87,    88,    89,    94,    93,    99,   100,    97,    98,    96,
      95,    84,    74,     0,    72,    64,    62,     0,   106,    76,
       0,    79,    75,     0,     0,    91,    83,     0,    68,     0,
      74,     0,     0,     0,     0,     0,    54,     0,    66,    70,
      73,    42,    78,    60,    77,    36,     0,     0,    74,     0,
      53,     0,    46,    71,     0,    43,    37,    55,     0,     0,
       0,    47,    59,    44,    38,    53,     0,    53,    53,    48,
      56,    45,    39,     0,     0,    49,    57,    53,     0,    50,
      58
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
    -184,  -184,  -184,    84,  -184,  -184,  -184,  -184,  -184,     4,
    -184,  -184,   227,  -184,  -184,  -184,  -184,  -184,   184,  -184,
    -184,  -184,   -50,  -184,  -184,  -184,  -184,  -184,  -184,  -184,
    -184,  -184,  -184,  -184,  -184,  -184,  -184,  -184,  -184,  -184,
    -184,  -184,  -184,  -184,  -183,  -184,  -184,  -184,  -158,  -184,
    -184,  -161,  -139,  -184,    95,   -63,   -49,   -84,   -36,   -46,
    -184
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int16 yydefgoto[] =
{
      -1,     2,     6,     3,     9,    34,    22,    47,    39,    18,
      49,    33,    12,    21,    13,    51,    82,    27,    44,    14,
      46,    77,    59,    78,   104,   173,   200,   210,   218,   102,
     167,   199,   209,   217,   208,   215,   223,   227,   109,   106,
     197,   213,   224,   228,    60,    61,   100,   162,   138,   198,
     180,   170,    62,    96,   134,    88,   115,    90,    91,    92,
      93
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int16 yytable[] =
{
      63,    67,   171,   116,   177,    63,    95,    97,    69,    83,
     168,    70,   169,    83,    84,     4,   205,   110,   140,    89,
     142,   192,   190,   194,   114,     1,    30,     5,   108,    85,
      86,   130,    63,    85,    86,   135,   136,    41,    87,     7,
     203,   226,    87,   171,    15,   171,   119,   120,     8,   112,
     113,   121,   122,    65,   149,   150,   151,   152,    10,   145,
     175,    83,    84,    63,   127,   128,    16,    17,    23,    19,
     161,    11,   153,   154,   155,   156,   157,   158,   159,   160,
      98,    85,    86,   121,   122,   123,   124,   125,   126,    99,
      94,    20,   172,    24,    25,    26,   127,   128,    28,   121,
     122,   123,   124,   125,   126,    31,   184,   121,   122,   123,
     124,   186,   127,   128,    52,    53,    68,    54,    42,   129,
     127,   128,    32,    48,    55,    69,    56,    35,    57,    58,
     189,    64,    37,   172,    36,   172,   204,    53,   207,    54,
      68,    38,   121,   122,   123,   124,   125,   126,    56,    69,
     206,    40,    70,    63,    63,   127,   128,    43,    45,    50,
     121,   122,   123,   124,   125,   219,    66,   221,   222,    63,
      71,    63,    63,   127,   128,    72,    73,   229,    63,    74,
      80,    63,   117,   118,   119,   120,   117,   118,   119,   120,
      75,   101,   147,    76,   133,   117,   118,   119,   120,    79,
     107,   103,   131,   117,   118,   119,   120,   105,   111,   132,
     163,   117,   118,   119,   120,    69,   146,   117,   118,   119,
     120,   137,   139,   141,   143,   144,   148,   164,   165,   166,
     174,   -41,   -35,   178,   179,   182,   181,   187,   196,   183,
     185,   188,   191,   193,   201,   195,   211,   216,    29,   202,
      81,     0,   212,   214,   225,   220,   176,   230
};

static const yytype_int16 yycheck[] =
{
      46,    51,   141,    87,   162,    51,    69,    70,    29,     3,
       4,    32,     6,     3,     4,     4,   199,    80,   102,    68,
     104,   182,   180,   184,    87,     5,    22,     0,    78,    23,
      24,    94,    78,    23,    24,    98,    99,    33,    32,    20,
     198,   224,    32,   182,     3,   184,    25,    26,    29,    85,
      86,     8,     9,    49,   117,   118,   119,   120,     4,   109,
     144,     3,     4,   109,    21,    22,     3,    31,    30,    32,
     133,    17,   121,   122,   123,   124,   125,   126,   127,   128,
      20,    23,    24,     8,     9,    10,    11,    12,    13,    29,
      32,    32,   141,     4,    28,     5,    21,    22,    33,     8,
       9,    10,    11,    12,    13,    28,    31,     8,     9,    10,
      11,   174,    21,    22,     4,     5,    20,     7,    34,    28,
      21,    22,    20,    39,    14,    29,    16,     4,    18,    19,
     179,    47,    34,   182,    33,   184,     4,     5,   201,     7,
      20,    28,     8,     9,    10,    11,    12,    13,    16,    29,
     200,     3,    32,   199,   200,    21,    22,    31,    34,     5,
       8,     9,    10,    11,    12,   215,     4,   217,   218,   215,
       4,   217,   218,    21,    22,    32,    32,   227,   224,    32,
      20,   227,    23,    24,    25,    26,    23,    24,    25,    26,
      32,     6,    33,    32,    31,    23,    24,    25,    26,    28,
      35,     6,    30,    23,    24,    25,    26,     5,    35,    33,
      30,    23,    24,    25,    26,    29,    28,    23,    24,    25,
      26,    31,    33,    31,     4,    28,    33,     4,    28,    28,
      20,    33,    33,    28,    20,    31,    33,    28,     4,    33,
      33,    28,    34,    28,    20,    34,    34,    15,    21,    33,
      66,    -1,    35,    35,    35,    34,   161,    35
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_int8 yystos[] =
{
       0,     5,    37,    39,     4,     0,    38,    20,    29,    40,
       4,    17,    48,    50,    55,     3,     3,    31,    45,    32,
      32,    49,    42,    30,     4,    28,     5,    53,    33,    48,
      45,    28,    20,    47,    41,     4,    33,    34,    28,    44,
       3,    45,    39,    31,    54,    34,    56,    43,    39,    46,
       5,    51,     4,     5,     7,    14,    16,    18,    19,    58,
      80,    81,    88,    95,    39,    45,     4,    58,    20,    29,
      32,     4,    32,    32,    32,    32,    32,    57,    59,    28,
      20,    54,    52,     3,     4,    23,    24,    32,    91,    92,
      93,    94,    95,    96,    32,    91,    89,    91,    20,    29,
      82,     6,    65,     6,    60,     5,    75,    35,    58,    74,
      91,    35,    94,    94,    91,    92,    93,    23,    24,    25,
      26,     8,     9,    10,    11,    12,    13,    21,    22,    28,
      91,    30,    33,    31,    90,    91,    91,    31,    84,    33,
      93,    31,    93,     4,    28,    58,    28,    33,    33,    91,
      91,    91,    91,    92,    92,    92,    92,    92,    92,    92,
      92,    91,    83,    30,     4,    28,    28,    66,     4,     6,
      87,    88,    92,    61,    20,    93,    90,    84,    28,    20,
      86,    33,    31,    33,    31,    33,    91,    28,    28,    92,
      84,    34,    87,    28,    87,    34,     4,    76,    85,    67,
      62,    20,    33,    84,     4,    80,    58,    91,    70,    68,
      63,    34,    35,    77,    35,    71,    15,    69,    64,    58,
      34,    58,    58,    72,    78,    35,    80,    73,    79,    58,
      35
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_int8 yyr1[] =
{
       0,    36,    38,    37,    40,    41,    39,    42,    43,    39,
      44,    39,    39,    46,    45,    47,    45,    45,    48,    49,
      48,    48,    51,    52,    50,    53,    53,    54,    54,    56,
      57,    55,    59,    58,    60,    61,    62,    63,    64,    58,
      65,    66,    67,    68,    69,    58,    70,    71,    72,    73,
      58,    74,    58,    58,    75,    76,    78,    79,    77,    77,
      80,    80,    80,    82,    81,    83,    81,    81,    81,    81,
      85,    84,    86,    84,    84,    87,    87,    87,    87,    87,
      88,    89,    89,    90,    90,    91,    91,    91,    91,    91,
      92,    92,    92,    93,    93,    93,    93,    93,    93,    93,
      93,    94,    94,    94,    94,    95,    96,    96,    96
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_int8 yyr2[] =
{
       0,     2,     0,     3,     0,     0,     7,     0,     0,     9,
       0,     8,     0,     0,     6,     0,     4,     0,     1,     0,
       3,     0,     0,     0,     9,     3,     0,     4,     0,     0,
       0,     8,     0,     3,     0,     0,     0,     0,     0,    13,
       0,     0,     0,     0,     0,    13,     0,     0,     0,     0,
      16,     0,     4,     0,     4,     3,     0,     0,     7,     1,
       7,     1,     5,     0,     5,     0,     7,     4,     6,     4,
       0,     6,     0,     4,     0,     1,     1,     3,     3,     1,
       4,     2,     0,     3,     0,     1,     3,     3,     3,     3,
       1,     1,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     1,     2,     2,     1,     4,     1,     1,     3
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
#line 51 "trad3.y"
                                { ; }
#line 1495 "trad3.tab.c"
    break;

  case 3:
#line 52 "trad3.y"
                                  { ; }
#line 1501 "trad3.tab.c"
    break;

  case 4:
#line 55 "trad3.y"
                                                            { sprintf(temp, "(setq %s 0)\n", (yyvsp[0].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1508 "trad3.tab.c"
    break;

  case 5:
#line 57 "trad3.y"
                                                            { ; }
#line 1514 "trad3.tab.c"
    break;

  case 6:
#line 58 "trad3.y"
                                                                                  { ; }
#line 1520 "trad3.tab.c"
    break;

  case 7:
#line 59 "trad3.y"
                                                              { sprintf(temp, "(setq %s %d)\n", (yyvsp[-2].cadena), (yyvsp[0].valor));
                                                          printf("%s", genera_cadena(temp)); }
#line 1527 "trad3.tab.c"
    break;

  case 8:
#line 61 "trad3.y"
                                                            { ; }
#line 1533 "trad3.tab.c"
    break;

  case 9:
#line 62 "trad3.y"
                                                                                  { ; }
#line 1539 "trad3.tab.c"
    break;

  case 10:
#line 66 "trad3.y"
                                                              { sprintf(temp, "(setq %s (make-array %d))\n", (yyvsp[-4].cadena), (yyvsp[-2].valor));
                                                              printf("%s", genera_cadena(temp)); }
#line 1546 "trad3.tab.c"
    break;

  case 11:
#line 68 "trad3.y"
                                                                            { ; }
#line 1552 "trad3.tab.c"
    break;

  case 12:
#line 72 "trad3.y"
                                                                { ; }
#line 1558 "trad3.tab.c"
    break;

  case 13:
#line 75 "trad3.y"
                                              { sprintf(temp, "(setq %s %d)\n", (yyvsp[-2].cadena), (yyvsp[0].valor));
                                                  printf("%s", genera_cadena(temp)); }
#line 1565 "trad3.tab.c"
    break;

  case 14:
#line 77 "trad3.y"
                                                { ; }
#line 1571 "trad3.tab.c"
    break;

  case 15:
#line 78 "trad3.y"
                                                { sprintf(temp, "(setq %s 0)\n", (yyvsp[0].cadena));
                                                  printf("%s", genera_cadena(temp)); }
#line 1578 "trad3.tab.c"
    break;

  case 16:
#line 80 "trad3.y"
                                                { ; }
#line 1584 "trad3.tab.c"
    break;

  case 17:
#line 81 "trad3.y"
                                                    { ; }
#line 1590 "trad3.tab.c"
    break;

  case 18:
#line 84 "trad3.y"
                                  { ; }
#line 1596 "trad3.tab.c"
    break;

  case 19:
#line 85 "trad3.y"
                                      { ; }
#line 1602 "trad3.tab.c"
    break;

  case 20:
#line 86 "trad3.y"
                                 { ; }
#line 1608 "trad3.tab.c"
    break;

  case 21:
#line 87 "trad3.y"
                                      { ; }
#line 1614 "trad3.tab.c"
    break;

  case 22:
#line 90 "trad3.y"
                                                 { sprintf(temp, "(defun %s (%s)\n", (yyvsp[-4].cadena), (yyvsp[-2].cadena));
                                            printf("%s", genera_cadena(temp));}
#line 1621 "trad3.tab.c"
    break;

  case 23:
#line 92 "trad3.y"
                                          { ; }
#line 1627 "trad3.tab.c"
    break;

  case 24:
#line 93 "trad3.y"
                                         { sprintf(temp, ")\n");
                                           printf("%s", genera_cadena(temp)); }
#line 1634 "trad3.tab.c"
    break;

  case 25:
#line 97 "trad3.y"
                                                       { sprintf(temp, "%s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                     (yyval.cadena) = genera_cadena(temp);}
#line 1641 "trad3.tab.c"
    break;

  case 26:
#line 99 "trad3.y"
                                                  { (yyval.cadena) = genera_cadena(""); }
#line 1647 "trad3.tab.c"
    break;

  case 27:
#line 102 "trad3.y"
                                                    { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 1654 "trad3.tab.c"
    break;

  case 28:
#line 104 "trad3.y"
                                                { (yyval.cadena) = genera_cadena(""); }
#line 1660 "trad3.tab.c"
    break;

  case 29:
#line 108 "trad3.y"
                                      { sprintf(temp, "(defun %s ()\n", (yyvsp[-3].cadena));
                                        printf("%s", genera_cadena(temp));}
#line 1667 "trad3.tab.c"
    break;

  case 30:
#line 110 "trad3.y"
                                      { ; }
#line 1673 "trad3.tab.c"
    break;

  case 31:
#line 111 "trad3.y"
                                      { sprintf(temp, ")\n");
                                        printf("%s", genera_cadena(temp)); }
#line 1680 "trad3.tab.c"
    break;

  case 32:
#line 115 "trad3.y"
                                                            { ; }
#line 1686 "trad3.tab.c"
    break;

  case 33:
#line 116 "trad3.y"
                                                                                { ; }
#line 1692 "trad3.tab.c"
    break;

  case 34:
#line 117 "trad3.y"
                                                            { sprintf(temp, "\t(loop %s ", (yyvsp[-1].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1699 "trad3.tab.c"
    break;

  case 35:
#line 119 "trad3.y"
                                                            { ; }
#line 1705 "trad3.tab.c"
    break;

  case 36:
#line 120 "trad3.y"
                                                            { strcat(temp, " do\n");
                                                              printf("%s", genera_cadena(temp)); }
#line 1712 "trad3.tab.c"
    break;

  case 37:
#line 122 "trad3.y"
                                                            { ; }
#line 1718 "trad3.tab.c"
    break;

  case 38:
#line 123 "trad3.y"
                                                            { sprintf(temp, "\t)\n");
                                                              printf("%s", genera_cadena(temp)); }
#line 1725 "trad3.tab.c"
    break;

  case 39:
#line 125 "trad3.y"
                                                                                { ; }
#line 1731 "trad3.tab.c"
    break;

  case 40:
#line 126 "trad3.y"
                                                            { sprintf(temp, "\t(if ");
                                                              printf("%s", genera_cadena(temp)); }
#line 1738 "trad3.tab.c"
    break;

  case 41:
#line 128 "trad3.y"
                                                            { ; }
#line 1744 "trad3.tab.c"
    break;

  case 42:
#line 129 "trad3.y"
                                                            { printf("%s\n\t", genera_cadena(temp)); }
#line 1750 "trad3.tab.c"
    break;

  case 43:
#line 130 "trad3.y"
                                                            { ; }
#line 1756 "trad3.tab.c"
    break;

  case 44:
#line 131 "trad3.y"
                                                            { ; }
#line 1762 "trad3.tab.c"
    break;

  case 45:
#line 132 "trad3.y"
                                                                                { ; }
#line 1768 "trad3.tab.c"
    break;

  case 46:
#line 133 "trad3.y"
                                                              { sprintf(temp, "%s\t(loop while %s", (yyvsp[-5].cadena), (yyvsp[-3].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1775 "trad3.tab.c"
    break;

  case 47:
#line 135 "trad3.y"
                                                            { sprintf(temp, " do\n");
                                                              printf("%s", genera_cadena(temp)); }
#line 1782 "trad3.tab.c"
    break;

  case 48:
#line 137 "trad3.y"
                                                            { ; }
#line 1788 "trad3.tab.c"
    break;

  case 49:
#line 138 "trad3.y"
                                                            { printf("%s\t)\n", (yyvsp[-7].cadena)); }
#line 1794 "trad3.tab.c"
    break;

  case 50:
#line 139 "trad3.y"
                                                            { ; }
#line 1800 "trad3.tab.c"
    break;

  case 51:
#line 140 "trad3.y"
                                                            { printf("\t%s\n", (yyvsp[-1].cadena)); }
#line 1806 "trad3.tab.c"
    break;

  case 52:
#line 141 "trad3.y"
                                                            { ; }
#line 1812 "trad3.tab.c"
    break;

  case 53:
#line 142 "trad3.y"
                                                                { ; }
#line 1818 "trad3.tab.c"
    break;

  case 54:
#line 145 "trad3.y"
                                                      { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 1825 "trad3.tab.c"
    break;

  case 55:
#line 149 "trad3.y"
                                              { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1832 "trad3.tab.c"
    break;

  case 56:
#line 153 "trad3.y"
                                      { printf("\t"); }
#line 1838 "trad3.tab.c"
    break;

  case 57:
#line 154 "trad3.y"
                                  { ; }
#line 1844 "trad3.tab.c"
    break;

  case 58:
#line 155 "trad3.y"
                                  { sprintf(temp, "\t)\n");
                                    printf("%s", genera_cadena(temp)); }
#line 1851 "trad3.tab.c"
    break;

  case 59:
#line 157 "trad3.y"
                                  { sprintf(temp, "\t)\n");
                                    printf("%s", genera_cadena(temp)); }
#line 1858 "trad3.tab.c"
    break;

  case 60:
#line 161 "trad3.y"
                                                              { if(strcmp(temp, "") != 0) printf("\t%s\n", genera_cadena(temp)); }
#line 1864 "trad3.tab.c"
    break;

  case 61:
#line 162 "trad3.y"
                                                        { ; }
#line 1870 "trad3.tab.c"
    break;

  case 62:
#line 163 "trad3.y"
                                                        { sprintf(temp, "\t(print \"%s\")\n", (yyvsp[-2].cadena));
                                                          printf("%s", genera_cadena(temp)); }
#line 1877 "trad3.tab.c"
    break;

  case 63:
#line 167 "trad3.y"
                                                            { sprintf(temp, "\t(setq %s 0)\n", (yyvsp[0].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1884 "trad3.tab.c"
    break;

  case 64:
#line 169 "trad3.y"
                                                            { ; }
#line 1890 "trad3.tab.c"
    break;

  case 65:
#line 170 "trad3.y"
                                                              { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1897 "trad3.tab.c"
    break;

  case 66:
#line 172 "trad3.y"
                                                            { ; }
#line 1903 "trad3.tab.c"
    break;

  case 67:
#line 173 "trad3.y"
                                                                { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1910 "trad3.tab.c"
    break;

  case 68:
#line 175 "trad3.y"
                                                              { sprintf(temp, "\t(setq %s (make-array %s))\n", (yyvsp[-4].cadena), (yyvsp[-2].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1917 "trad3.tab.c"
    break;

  case 69:
#line 177 "trad3.y"
                                                              { sprintf(temp, "\t(setf %s %s)\n", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                              printf("%s", genera_cadena(temp)); }
#line 1924 "trad3.tab.c"
    break;

  case 70:
#line 181 "trad3.y"
                                                  { sprintf(temp, "\t(setq %s %s)\n", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  printf("%s", genera_cadena(temp)); }
#line 1931 "trad3.tab.c"
    break;

  case 71:
#line 183 "trad3.y"
                                                { ; }
#line 1937 "trad3.tab.c"
    break;

  case 72:
#line 184 "trad3.y"
                                                { sprintf(temp, "\t(setq %s 0)\n", (yyvsp[0].cadena));
                                                  printf("%s", genera_cadena(temp)); }
#line 1944 "trad3.tab.c"
    break;

  case 73:
#line 186 "trad3.y"
                                                { ; }
#line 1950 "trad3.tab.c"
    break;

  case 74:
#line 187 "trad3.y"
                                                    { ; }
#line 1956 "trad3.tab.c"
    break;

  case 75:
#line 190 "trad3.y"
                                                { sprintf(temp, "(print %s )", (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1963 "trad3.tab.c"
    break;

  case 76:
#line 192 "trad3.y"
                                              { strcpy(temp, "");
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1970 "trad3.tab.c"
    break;

  case 77:
#line 194 "trad3.y"
                                              { sprintf(temp, "(print %s) %s", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1977 "trad3.tab.c"
    break;

  case 78:
#line 196 "trad3.y"
                                            { sprintf(temp, "%s", (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1984 "trad3.tab.c"
    break;

  case 79:
#line 198 "trad3.y"
                                            { sprintf(temp, "(print %s)", (yyvsp[0].cadena));
                                              (yyval.cadena) = genera_cadena(temp); }
#line 1991 "trad3.tab.c"
    break;

  case 80:
#line 202 "trad3.y"
                                              { sprintf(temp, "(%s%s)", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                (yyval.cadena) = genera_cadena(temp); }
#line 1998 "trad3.tab.c"
    break;

  case 81:
#line 206 "trad3.y"
                                                  { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                     (yyval.cadena) = genera_cadena(temp);}
#line 2005 "trad3.tab.c"
    break;

  case 82:
#line 208 "trad3.y"
                                                    { (yyval.cadena) = genera_cadena(""); }
#line 2011 "trad3.tab.c"
    break;

  case 83:
#line 210 "trad3.y"
                                                   { sprintf(temp, " %s%s", (yyvsp[-1].cadena), (yyvsp[0].cadena));
                                                     (yyval.cadena) = genera_cadena(temp);}
#line 2018 "trad3.tab.c"
    break;

  case 84:
#line 212 "trad3.y"
                                                    { (yyval.cadena) = genera_cadena(""); }
#line 2024 "trad3.tab.c"
    break;

  case 85:
#line 215 "trad3.y"
                                                                        { (yyval.cadena) = (yyvsp[0].cadena); }
#line 2030 "trad3.tab.c"
    break;

  case 86:
#line 216 "trad3.y"
                                              { sprintf(temp, "(+ %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                (yyval.cadena) = genera_cadena(temp); }
#line 2037 "trad3.tab.c"
    break;

  case 87:
#line 218 "trad3.y"
                                              { sprintf(temp, "(- %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                (yyval.cadena) = genera_cadena(temp); }
#line 2044 "trad3.tab.c"
    break;

  case 88:
#line 220 "trad3.y"
                                                        { sprintf(temp, "(* %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                (yyval.cadena) = genera_cadena(temp); }
#line 2051 "trad3.tab.c"
    break;

  case 89:
#line 222 "trad3.y"
                                                        { sprintf(temp, "(/ %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                (yyval.cadena) = genera_cadena(temp); }
#line 2058 "trad3.tab.c"
    break;

  case 90:
#line 226 "trad3.y"
                                        { (yyval.cadena) = genera_cadena(temp); }
#line 2064 "trad3.tab.c"
    break;

  case 91:
#line 227 "trad3.y"
                                        { (yyval.cadena) = genera_cadena(temp); }
#line 2070 "trad3.tab.c"
    break;

  case 92:
#line 228 "trad3.y"
                                            { sprintf(temp, "(%s)", (yyvsp[-1].cadena));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2077 "trad3.tab.c"
    break;

  case 93:
#line 232 "trad3.y"
                                                { sprintf(temp, "(>= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2084 "trad3.tab.c"
    break;

  case 94:
#line 234 "trad3.y"
                                                { sprintf(temp, "(<= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2091 "trad3.tab.c"
    break;

  case 95:
#line 236 "trad3.y"
                                                { sprintf(temp, "(> %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2098 "trad3.tab.c"
    break;

  case 96:
#line 238 "trad3.y"
                                                { sprintf(temp, "(< %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2105 "trad3.tab.c"
    break;

  case 97:
#line 240 "trad3.y"
                                                { sprintf(temp, "(and %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2112 "trad3.tab.c"
    break;

  case 98:
#line 242 "trad3.y"
                                                  { sprintf(temp, "(or %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2119 "trad3.tab.c"
    break;

  case 99:
#line 244 "trad3.y"
                                                 { sprintf(temp, "(= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2126 "trad3.tab.c"
    break;

  case 100:
#line 246 "trad3.y"
                                                { sprintf(temp, "(/= %s %s)", (yyvsp[-2].cadena), (yyvsp[0].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2133 "trad3.tab.c"
    break;

  case 101:
#line 250 "trad3.y"
                                                                      { (yyval.cadena) = (yyvsp[0].cadena); }
#line 2139 "trad3.tab.c"
    break;

  case 102:
#line 251 "trad3.y"
                                                      { sprintf(temp, "(+ %s)", (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 2146 "trad3.tab.c"
    break;

  case 103:
#line 253 "trad3.y"
                                                        { sprintf(temp, "(- %s)", (yyvsp[0].cadena));
                                                      (yyval.cadena) = genera_cadena(temp); }
#line 2153 "trad3.tab.c"
    break;

  case 104:
#line 255 "trad3.y"
                                                          { (yyval.cadena) = genera_cadena((yyvsp[0].cadena)); }
#line 2159 "trad3.tab.c"
    break;

  case 105:
#line 258 "trad3.y"
                                                { sprintf(temp, "(aref %s %s)", (yyvsp[-3].cadena), (yyvsp[-1].cadena));
                                                  (yyval.cadena) = genera_cadena(temp); }
#line 2166 "trad3.tab.c"
    break;

  case 106:
#line 262 "trad3.y"
                                                { sprintf(temp,"%s", (yyvsp[0].cadena));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2173 "trad3.tab.c"
    break;

  case 107:
#line 264 "trad3.y"
                                        { sprintf(temp,"%d", (yyvsp[0].valor));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2180 "trad3.tab.c"
    break;

  case 108:
#line 266 "trad3.y"
                                              { sprintf(temp, "(%s)", (yyvsp[-1].cadena));
                                          (yyval.cadena) = genera_cadena(temp); }
#line 2187 "trad3.tab.c"
    break;


#line 2191 "trad3.tab.c"

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
#line 270 "trad3.y"

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
