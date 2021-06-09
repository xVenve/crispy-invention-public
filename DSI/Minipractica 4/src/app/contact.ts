
export class IContact {
  id: number;
  name: string;
  phone: string;
  email?: string;
  type?: number;
  specialty?: number;
  regular?: boolean;
  address?: string;
  company?: string;
  charge?: string;
  birthday?: Date;
  info?: String;
};


export class Contact implements IContact {
  id: number;
  name: string;
  phone: string;
  email?: string;
  type?: number;
  specialty?: number;
  regular?: boolean;
  address?: string;
  company?: string;
  charge?: string;
  birthday?: Date;
  info?: String;

  constructor(o?: IContact) {
    if (o !== undefined) Object.assign(this, o);
  }
}

export class ViewContact {
  private static TYPES: string[] = ["", "Personal", "Work", "Partner"];
  private static SPECIALTY: string[] = ["", "Development", "Agile", "DevOps"];

  public static getType(contact: Contact) {
    return ViewContact.TYPES[contact.type];
  }

  public static getSpecialties(contact: Contact) {
    return ViewContact.SPECIALTY[contact.specialty];
  }

  public static getSpecialty() {
    return ViewContact.SPECIALTY;
  }

  public static getTypes() {
    return ViewContact.TYPES;
  }

  public static getRegular(contact: Contact) {
    return contact.regular ? "Yes" : "No";
  }

  public static getBirthday(contact: Contact) {
    return contact.birthday;
  }
}

